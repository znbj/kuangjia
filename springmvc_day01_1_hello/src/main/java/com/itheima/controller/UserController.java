package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET,params = {"name"})
    public String test() {
        System.out.println("hello 执行了");
        return "show";
    }
}
