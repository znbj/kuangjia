package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("success");
       return "show";
    }

    @RequestMapping("/testParam")
    public String testParam(String name) {

        System.out.println(name);

        return "show";
    }

    @RequestMapping("/testPojo")
    public String testPojo(User user) {

        System.out.println(user);

        return "show";
    }

    @RequestMapping("/testDate")
    public String testDate(User user) {

        System.out.println(user.getBirthday());

        return "show";
    }
}
