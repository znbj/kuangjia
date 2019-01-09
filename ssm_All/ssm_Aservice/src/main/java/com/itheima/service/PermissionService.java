package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 查询所有权限
     * @return
     */
    List<Permission> findAll();

    /**
     * 查询父权限列表
     * @return
     */
    List<Permission> findParents();

    /**
     * 保存权限
     * @param permission
     */
    void save(Permission permission);

    /**
     * 查询无父权限
     * @return
     */
    List<Permission> findNotParents();
}
