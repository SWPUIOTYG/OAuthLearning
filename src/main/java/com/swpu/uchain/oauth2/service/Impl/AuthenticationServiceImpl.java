package com.swpu.uchain.oauth2.service.Impl;

import com.swpu.uchain.oauth2.model.AuthenticationRequest;
import com.swpu.uchain.oauth2.model.UserDto;
import com.swpu.uchain.oauth2.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        //校验参数是否为空
        if(authenticationRequest==null || StringUtils.isEmpty(authenticationRequest.getPassword())
                || StringUtils.isEmpty(authenticationRequest.getUsername())){
           throw new RuntimeException("账号或密码为空");
        }
        UserDto user=getUserDto(authenticationRequest.getUsername());
        if(user==null){
            throw new RuntimeException("查询不到该用户");
        }
        if(!authenticationRequest.getPassword().equals(user.getPassword())){
            throw new RuntimeException("密码错误");
        }
        return user;
    }
    private UserDto getUserDto(String username){
        return userMap.get(username);
    }

    //构建用户信息Map
    private Map<String,UserDto> userMap=new HashMap<>();
    {
        Set<String> authories1=new HashSet<>();//权限set set因为权限可能有多个
        authories1.add("p1");//授予p1的权限  与资源r/r1对应
        Set<String> authories2=new HashSet<>();//权限set
        authories2.add("p2");//授予p2的权限 与资源r/r2对应
        userMap.put("Damon",new UserDto("1","Damon","123456","Damon","147258369",authories1));
        userMap.put("Stefan",new UserDto("2","Stefan","123456","Stefan","369258147",authories2));
    }
}
