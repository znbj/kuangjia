package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDao {

    @Select("select * from orders")
    @Results({
            @Result(property = "product",column = "productId",javaType = Product.class,
            one = @One(select = "com.itheima.dao.ProductDao.findById"))
    })
    List<Order> findAll();

    @Select("select * from orders where id = #{id}")
    Order findById(Integer id);

    @Delete("delete from orders where id = #{id}")
    void delById(Integer id);

    @Update("update orders set orderTime=#{orderTime},peopleCount=#{peopleCount},orderDesc=#{orderDesc},payType=#{payType},orderStatus=#{orderStatus}")
    void update(Order order);

    @Insert("insert into orders values(order_seq.nextval,#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    void save(Order order);
}
