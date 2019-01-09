package com.itheima;

import com.itheima.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDi {
    @Test
    public void testDI() {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)ac.getBean("User");

        System.out.println(user);

    }

}
