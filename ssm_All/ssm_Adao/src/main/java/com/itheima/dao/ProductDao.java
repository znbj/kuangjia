package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {

    @Select("select * from product")
    List<Product> findAll();


    @Insert("insert into product values(product_seq.nextval,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id = #{id}")
    Product findById(Integer id);

    @Delete("delete from product where id = #{id}")
    void delById(Integer id);

    @Update("update product set productNum = #{productNum},productName=#{productName},cityName=#{cityName}," +
            "departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} " +
            "where id = #{id}")
    void update(Product product);
}
