package com.itheima.dao;

import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Select("select * from sys_User where UserName = #{name} and status = 1")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleList",column = "id",javaType = List.class,
            many = @Many(select = "com.itheima.dao.RoleDao.findByUId",fetchType = FetchType.LAZY))
    })
    SysUser findByUserName(String username);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from sys_user")
    List<SysUser> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into sys_user values(user_seq.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser user);

    /**
     * 校验用户名是否存在
     * @param username
     * @return
     */
    @Select("select * from sys_user where username=#{username}")
    SysUser checkOutUsername(String username);

    /**
     * 根据用户id查询 多表查询
     * @param id
     * @return
     */
    @Select("select * from sys_user where id =#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "roleList",column = "id",javaType = List.class,
            many = @Many(select = "com.itheima.dao.RoleDao.findByUId",fetchType = FetchType.LAZY))
    })
    SysUser findById(Long id);

    /**
     * 删除用户角色关系
     * @param userId
     */
    @Delete("delete from sys_user_role where userId = #{userId}")
    void delUserRoles(Long userId);

    /**
     * 添加角色给用户
     * @param userId
     * @param id
     */
    @Insert("insert into sys_user_role values(#{param1},#{param2})")
    void addRoleToUser(Long userId, Long id);
}
