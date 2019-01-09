package com.itheima;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.utils.TransactionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
    AccountServiceImpl accountServiceImpl;
    @Autowired
    TransactionManager tm;

    @Test
    public void testProxy() {

        AccountService accountServiceProxy=(AccountService)Proxy.newProxyInstance(accountServiceImpl.getClass().getClassLoader(), accountServiceImpl.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            tm.beginTransaction();
                            method.invoke(accountServiceImpl, args);
                            tm.commit();
                        } catch (Exception e) {
                            tm.rollback();
                            e.printStackTrace();
                        } finally {
                            tm.release();
                        }
                        return null;
                    }
                }
        );
        accountServiceProxy.transfer("aaa","ccc",100f);
    }

    @Test
    public void testCglib() {

        AccountServiceImpl accountServiceCglib=(AccountServiceImpl)Enhancer.create(accountServiceImpl.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object rtValue=null;
                try {
                    tm.beginTransaction();
                    rtValue=method.invoke(accountServiceImpl, objects);
                    tm.commit();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    tm.rollback();
                }finally {
                    tm.release();
                }


                return rtValue;

            }
        });
        accountServiceCglib.transfer("aaa", "ccc", 100f);

    }
}
