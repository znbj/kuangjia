package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Order> orderList = orderService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderList",orderList);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }
    @RequestMapping("/findByPageHelper")
    public ModelAndView findByPageHelper(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize) {
        PageInfo<Order> pageInfo=orderService.findByPageHelper(pageNum,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }

    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id) {
        Order orders= orderService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("order-update");
        return modelAndView;
    }

    @RequestMapping("/del")
    public String delById(Integer id) {
        orderService.delById(id);
        return "redirect:findAll";
    }
    @RequestMapping("/update")
    public String update(Order order) {
        orderService.update(order);
        return "redirect:findAll";
    }
    @RequestMapping("/save")
    public String save(Order order){
        orderService.save(order);
        return "redirect:findAll";
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        List<Product> productList = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("order-add");
        return modelAndView;
    }
}
