package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountDao {
    /**
     *查询所有
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     *根据id查询
     * @param id
     * @return
     */
    @Select("select * from account where id =#{id}")
    public Account findById(Integer id);

    /**
     *模糊查询
     * @param name
     * @return
     */
    @Select("select * from account where cardNumber like \"%\"#{name}\"%\" ")
    public List<Account> findByNames(String name);

    /**
     *保存
     * @param account
     */
    @SelectKey(keyColumn = "u_id",keyProperty = "id",before = false,resultType =Integer.class,statement = {"select last_insert_id()"})
    @Insert("insert into account values(null,#{money},#{cardNumber},#{u_id})")
    public void save(Account account);

    /**
     * 分页查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<Account> findByPage(Integer startIndex, Integer pageSize);

    /**
     * 修改
     * @param account
     */
    @Update("update account set cardNumber=#{cardNumber} where id=#{id}")
    public void update(Account account);

    /**
     * 删除
     * @param id
     */

    @Delete("delete from account where id =#{id}")
    public void del(Integer id);

}
