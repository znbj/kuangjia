package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/rest")
public class testRestController {

    @RequestMapping(value = "/operate/{id}",method = RequestMethod.GET)
    public String  findById(@PathVariable("id") Integer id) {
        System.out.println("根据id查询"+id);

        return "success";
    }
    @RequestMapping(value = "/operate/{id}",method = RequestMethod.POST)
    public String save(@PathVariable("id") Integer id) {
        System.out.println("保存"+id);
        return "success";
    }
    @RequestMapping(value = "/operate/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String upDate(@PathVariable("id") Integer id, HttpServletResponse response) {

        System.out.println("更新"+id);
        return "success";
    }

    @RequestMapping(value = "/operate/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String del(@PathVariable("id") Integer id, HttpServletResponse response) {

        System.out.println("删除"+id);
        return "success";
    }
}
