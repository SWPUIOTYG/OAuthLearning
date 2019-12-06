package com.swpu.uchain.oauth2.controller;

import com.swpu.uchain.oauth2.model.AuthenticationRequest;
import com.swpu.uchain.oauth2.model.UserDto;
import com.swpu.uchain.oauth2.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login", produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest request, HttpSession session) {
        UserDto userDto=authenticationService.authentication(request);
        //存入session  setAttribute方法 获取session getAttribute方法
        session.setAttribute(userDto.SESSION_USER_KEY,userDto);
        return userDto.getUsername()+"登录成功";
    }

    @GetMapping(value = "/r/r1",produces = "text/plain;charset=utf-8")
    public String getSession(HttpSession session){
        String fullname=null;
        Object object=session.getAttribute(UserDto.SESSION_USER_KEY);
        if(object==null){
            return "匿名访问";
        }
        else{
            UserDto userDto=(UserDto)object;
            fullname=userDto.getFullname();
        }
        return fullname+"访问资源r1";
    }
    @GetMapping(value = "/logout",produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }

}
