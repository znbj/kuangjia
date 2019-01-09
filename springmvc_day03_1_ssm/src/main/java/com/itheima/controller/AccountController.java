package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accountList = accountService.findAll();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("accountShow");
        return modelAndView;
    }

    @RequestMapping("/delById")
    public String delById(Integer id) {
        accountService.delById(id);
        return "redirect:findAll";
    }
    @RequestMapping("/save")
    public String save(Account account) {
        accountService.save(account);

        return "redirect:findAll";
    }

    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Account account = accountService.findById(id);
        modelAndView.addObject("account", account);
        modelAndView.setViewName("account-update");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Account account) {
        accountService.update(account);

        return "redirect:findAll";
    }
}
