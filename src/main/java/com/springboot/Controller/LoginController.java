package com.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/Login")
    public String login(@RequestParam String username, @RequestParam String password,
                        Map<String,Object> map, HttpServletRequest request, HttpServletResponse response){


        if(!username.equals("admin")){
            System.out.println(username);
            map.put("msg","用户名密码错误");
            return "login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        return "dashboard";
    }

}
