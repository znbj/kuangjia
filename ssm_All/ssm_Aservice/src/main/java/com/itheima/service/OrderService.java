package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;

import java.util.List;

public interface OrderService {
    /**
     * 查询所有订单
     * @return
     */
    List<Order> findAll();

    /**
     * 根据id删除
     * @param id
     */
    void delById(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Order findById(Integer id);

    /**
     * 更新订单表
     * @param order
     */
    void update(Order order);

    /**
     * 保存订单
     * @param order
     */
    void save(Order order);

    /**
     * 分页插件 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Order> findByPageHelper(Integer pageNum, Integer pageSize);
}
