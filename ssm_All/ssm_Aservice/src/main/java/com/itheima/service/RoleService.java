package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();

    /**
     * 保存角色
     * @param role
     */
    void save(Role role);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Role findById(Long id);

    /**
     *
     * @param roleId
     * @param ids
     */
    void addPermissionToRole(Long roleId, Long[] ids);
}
