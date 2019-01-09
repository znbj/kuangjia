package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    /**
     * 查询所有权限
     * @return
     */
    @Select("select * from sys_permission")
    List<Permission> findAll();

    /**
     * 查询父权限
     * @return
     */
    @Select("select * from sys_permission where pid = 0")
    List<Permission> findParents();

    /**
     * 保存权限
     * @param permission
     */
    @Insert("insert into sys_permission values(permission_seq.nextval,#{permissionName},#{url},#{pid})")
    void save(Permission permission);


    /**
     *
     * @param rid
     * @return
     */
    @Select("select p.* from sys_role_permission rp,sys_permission p  where rp.roleId = #{roleId} and rp.permissionid = p.id")
    List<Permission> findByRid(Long rid);

    /**
     *
     * @return
     */
    @Select("select * from sys_permission where pid in(1,2)")
    List<Permission> findNotParents();
}
