package com.swpu.uchain.oauth2.interceptor;

import com.swpu.uchain.oauth2.model.UserDto;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//过滤器 校验用户请求url是否在用户权限范围内
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{

        //Session取出用户信息
        Object object=request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if(object==null){
           writeContent(response,"请登录");//响应信息
        }
        UserDto userDto=(UserDto)object; //获取用户
        String requestURL=request.getRequestURI();
        if(requestURL.contains("/r/r1") && userDto.getAuthorities().contains("p1")){
            return true;
        }
        if(requestURL.contains("/r/r2") && userDto.getAuthorities().contains("p2")){
            return true;
        }
        writeContent(response,"权限不足,拒绝访问");
        return false;
    }
    //返回响应信息
    private void writeContent(HttpServletResponse response,String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();
    }
}
