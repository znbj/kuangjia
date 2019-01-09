package com.itheima.service;

import com.itheima.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    UserDetails loadUserByUsername(String username);

    /**
     * 查询所有用户
     * @return
     */
    List<SysUser> findAll();

    /**
     * 保存用户
     * @param user
     */
    void save(SysUser user);

    /**
     * 校验用户名是否存在
     * @param username
     * @return
     */
    Boolean checkOutUsername(String username);

    /**
     * 多表查询 根据id
     * @param id
     * @return
     */
    SysUser findById(Long id);

    /**
     * 给用户更新角色
     * @param userId
     * @param ids
     */
    void addRolesToUser(Long userId, Long[] ids);
}
