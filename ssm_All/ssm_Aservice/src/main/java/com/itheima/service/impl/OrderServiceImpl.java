package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderDao orderDao;
    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public void delById(Integer id) {
        orderDao.delById(id);
    }

    @Override
    public Order findById(Integer id) {
        return orderDao.findById(id);
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public PageInfo<Order> findByPageHelper(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orderList = orderDao.findAll();
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList);
        return orderPageInfo;
    }
}
