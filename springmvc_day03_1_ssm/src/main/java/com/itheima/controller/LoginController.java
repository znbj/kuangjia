package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username , String password){
        //模拟验证用户名与密码是否匹配
        if("jack".equals(username) && "123".equals(password)){
            request.getSession().setAttribute("username",username);
            String path = request.getContextPath();
            System.out.println("登录成功");
            System.out.println(path);
            //如果登录成功，直接查询所有的账户，在页面展示
            return "redirect:"+path+"/account/findAll";

        }else{
            //localhost:8080/login.jsp
            //动态获取项目的根路径
            String path = request.getContextPath();

            return "redirect:"+path+"/login.jsp";
        }


    }
}
