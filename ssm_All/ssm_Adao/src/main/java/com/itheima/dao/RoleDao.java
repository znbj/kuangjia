package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleDao {

    /**
     * 查询所有角色
     * @return
     */
    @Select("select * from sys_role")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "permissionList",column = "id",javaType = List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findByRid",fetchType = FetchType.LAZY))
    })
    List<Role> findAll();

    /**
     * 保存角色
     * @param role
     */

    @Insert("insert into sys_role values(role_seq.nextval,#{roleName},#{roleDesc})")
    void save(Role role);

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    @Select("select r.* from sys_user_role ur,sys_role r where userId = #{userId} and ur.roleid = r.id")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "permissionList",column = "id",javaType = List.class,
            many = @Many(select = "com.itheima.dao.PermissionDao.findByRid",fetchType = FetchType.LAZY))
    })
    List<Role> findByUId(Long id);

    /**
     * 根据角色id
     * @param id
     * @return
     */
    @Select("select * from sys_role where id=#{id} ")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property ="permissionList",column ="id",javaType = List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findByRid",fetchType = FetchType.LAZY))
    })
    Role findByRid(Long id);

    /**
     *
     * @param roleId
     */
    @Delete("delete from sys_role_permission where roleId=#{roleId}")
    void delPermissionFromRole(Long roleId);

    /**
     *
     * @param roleId
     * @param id
     */
    @Insert("insert into sys_role_permission values(#{param2},#{param1})")
    void addPermissionToRole(Long roleId, Long id);
}
