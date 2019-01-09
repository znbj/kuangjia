package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(Long id) {
        return roleDao.findByRid(id);
    }

    @Override
    public void addPermissionToRole(Long roleId, Long[] ids) {
        System.out.println(roleId);
        System.out.println("-----");
        roleDao.delPermissionFromRole(roleId);
        if (ids != null && ids.length > 0) {
            for (Long id : ids) {
                System.out.println(id);
                System.out.println("-----");
                roleDao.addPermissionToRole(roleId,id);
            }
        }
    }


}
