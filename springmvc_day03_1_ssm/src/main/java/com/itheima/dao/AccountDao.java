package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {
    /**
     * 查全部
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     *新增
     * @param account
     */
    @Insert("insert into account values(null,#{username},#{money})")
    public void save(Account account);

    /**
     *修改
     * @param account
     */
    @Update("update account set username=#{username},money=#{money} where id=#{id}")
    public void update(Account account);

    /**
     *根据id删除
     * @param id
     */
    @Delete("delete from account where id=#{id}")
    public void delById(Integer id);

    /**
     *根据id查找
     * @param id
     * @return
     */
    @Select("select * from account where id=#{id}")
    public Account findById(Integer id);
}
