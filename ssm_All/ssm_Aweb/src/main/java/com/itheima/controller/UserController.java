package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<SysUser> userList=userService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(SysUser user) {
        userService.save(user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/checkOutUsername")
    @ResponseBody
    public String checkOutUsername(String username) {
        Boolean bool=userService.checkOutUsername(username);

        return bool+"";

    }

    @RequestMapping("/userDetailUI")
    public ModelAndView userDetailUI(Long id){
        SysUser user=userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/addUserRoleUI")
    public ModelAndView addUserRoleUI(Long id) {
        //查询用户所有角色
        List<Role> roleList = roleService.findAll();
        //查询当前用户得角色
        SysUser user = userService.findById(id);
        //获得当前用户得角色
        List<Role> userRoleList = user.getRoleList();
        //拼接角色id字符串
        StringBuffer stringBuffer = new StringBuffer();
        for (Role role : userRoleList) {
            stringBuffer.append(",");
            stringBuffer.append(role.getId());
            stringBuffer.append(",");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",roleList);
        modelAndView.addObject("userId",user.getId());
        modelAndView.addObject("userRoleStr",stringBuffer.toString());
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(Long userId,Long[] ids) {
        userService.addRolesToUser(userId,ids);
        return "redirect:/user/findAll";
    }


}
