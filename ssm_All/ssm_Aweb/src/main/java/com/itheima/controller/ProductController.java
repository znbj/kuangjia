package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Product> productList=productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", productList);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Product product) {

        productService.save(product);

        return "redirect:findByPageHelper";
    }

    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id) {
        Product product= productService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",product);
        modelAndView.setViewName("product-update");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Product product) {
        productService.update(product);

        return "redirect:findByPageHelper";
    }

    @RequestMapping("/del")
    public String del(Integer id) {
        productService.delById(id);

        return "redirect:findByPageHelper";
    }

    @RequestMapping("/delProducts")
    public String delProducts(Integer[] ids) {
        if (ids == null) {
            return "redirect:findByPageHelper";
        }
        productService.delProducts(ids);

        return "redirect:findByPageHelper";

    }


    @RequestMapping("/findByPageHelper")
    public ModelAndView findByPageHelper(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageInfo<Product> pageInfo= productService.findByPageHelper(pageNum,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;

    }
}
