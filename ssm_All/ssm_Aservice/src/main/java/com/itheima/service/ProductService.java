package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有
     * @return
     */
    List<Product> findAll();

    /**
     * 保存
     * @param product
     */
    void save(Product product);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product findById(Integer id);


    /**
     * 根据id删除
     * @param id
     */
    void delById(Integer id);

    /**
     * 更新操作
     * @param product
     */
    void update(Product product);

    /**
     * 删除多个
     * @param ids
     */
    void delProducts(Integer[] ids);

    /**
     * 分页插件
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Product> findByPageHelper(Integer pageNum, Integer pageSize);
}
