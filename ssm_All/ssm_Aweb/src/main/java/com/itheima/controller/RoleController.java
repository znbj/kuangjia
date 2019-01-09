package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.PermissionService;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Role> roleList=roleService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/findAll";
    }

    @RequestMapping("/addPermissionUI")
    public ModelAndView addPermissionUI(Long id) {
        List<Permission> permissionList = permissionService.findNotParents();
        Role role=roleService.findById(id);

        List<Permission> rolePermissionList = role.getPermissionList();
        StringBuffer stringBuffer=new StringBuffer();
        for (Permission permission : rolePermissionList) {
            stringBuffer.append(",");
            stringBuffer.append(permission.getId());
            stringBuffer.append(",");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.addObject("role",role);
        modelAndView.addObject("rolePermissionStr",stringBuffer.toString());
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(Long roleId,Long[] ids) {
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:/role/findAll";
    }

}
