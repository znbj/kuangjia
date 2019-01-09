package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/user")
@SessionAttributes(names = {"username","password"})
public class UserController {
    @RequestMapping("/test")
    public String test() {
        System.out.println("success");
        return "success";
    }

    @ModelAttribute
    public void findByUserName(String name, Map<String,Object> map) {
        User user = new User();
        user.setAddress("河南");
        user.setId(1);
        user.setAge(16);
        user.setName("迪丽热巴");
        map.put("aaa",user);
    }

    @RequestMapping(value = "/testUpdate",method = RequestMethod.POST)
    public String testUpdate(@ModelAttribute("aaa") User user) {
        System.out.println("update"+user);
        return "success";
    }

    /**
     * 保存session
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/saveSession")
    public String saveSessionAttribute(Model model, HttpServletRequest request) {
        model.addAttribute("username","zhang");
        model.addAttribute("password","123456");
        return "success";
    }

    /**
     *获得session
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSession")
    public String getSession(ModelMap modelMap) {
        System.out.println(modelMap.get("username"));
        System.out.println(modelMap.get("password"));
        return "success";
    }

    /**
     *清理session
     * @param status
     * @return
     */
    @RequestMapping("/cleanSession")
    public String cleanSession(SessionStatus status) {
        System.out.println("清除成功");
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletResponse response) {

        System.out.println("void");
        try {
            response.getWriter().print("kkkk");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/testStringZ")
    public String testString1() {

        System.out.println("String");

        return "forward:test";
    }

    @RequestMapping("/testStringQ")
    public String testString2() {

        System.out.println("String");

        return "redirect:test";
    }
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        User user = new User();
        user.setId(1);
        user.setName("maliu");
        user.setAddress("北京市朝阳区");
        user.setAge(20);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testjson")
    @ResponseBody
    public User testJSON( String name) {
        System.out.println(name);
        User user = new User();
        user.setId(1);
        user.setName("maliu");
        user.setAddress("北京市朝阳区");
        user.setAge(20);
        return user;
    }




}
