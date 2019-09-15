package com.springboot.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if(username == null){
            request.setAttribute("msg","请登录");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }
        return true;
    }


}
