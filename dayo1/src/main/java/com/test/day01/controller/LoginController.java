package com.test.day01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpServletRequest request){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //设置session
            request.getSession().setAttribute("username",username);
            //重定向可以防止表单重新提交
            return "redirect:dashboard.html";
        }else {
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
    @GetMapping("/singout")
    public String singOut(HttpServletRequest request){
        request.getSession().removeAttribute("username");
        return "login";
    }
}
