package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser=userDao.findByUserName(username);

        if (sysUser != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            List<Role> roleList = sysUser.getRoleList();
            for (Role role : roleList) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));

            }
            UserDetails user=new User(sysUser.getUsername(),sysUser.getPassword(),authorities);
            return user;
        }
        return null;
    }

    @Override
    public List<SysUser> findAll() {

        return userDao.findAll();
    }

    @Override
    public void save(SysUser user) {
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userDao.save(user);
    }

    @Override
    public Boolean checkOutUsername(String username) {

        SysUser user=userDao.checkOutUsername(username);

        return user==null;

    }

    @Override
    public SysUser findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void addRolesToUser(Long userId, Long[] ids) {
        userDao.delUserRoles(userId);
        if (ids != null && ids.length > 0) {
            for (Long id : ids) {
                userDao.addRoleToUser(userId,id);
            }
        }

    }
}
