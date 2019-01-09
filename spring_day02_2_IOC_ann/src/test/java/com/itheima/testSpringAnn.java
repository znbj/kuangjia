package com.itheima;

import com.itheima.dao.AccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpringAnn {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao bean = ac.getBean(AccountDao.class);
        System.out.println(bean);


    }
}
