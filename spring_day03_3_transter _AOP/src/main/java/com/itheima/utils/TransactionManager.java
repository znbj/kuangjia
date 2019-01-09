package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("txManger")
public class TransactionManager {

    @Autowired
    private ConnectionUtil connectionUtil;


    public void beginTransaction() {
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            connectionUtil.getThreadConnection().setAutoCommit(true);

            connectionUtil.getThreadConnection().close();

            connectionUtil.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
