package com.itheima;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class TestIOC {

    @Test
    public void testApplicationContext() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Object userDao = ac.getBean("UserDao");
        System.out.println(userDao);
        Object userDao1 = ac.getBean("UserDao");
        System.out.println(userDao1);
        /*Object userService = ac.getBean("UserService");
        System.out.println(userService);*/

    }
    @Test
    public void testBeanFactory() {
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        Object userDao = beanFactory.getBean("UserDao");
        Object userService = beanFactory.getBean("UserService");
        System.out.println(userDao);
    }
}
