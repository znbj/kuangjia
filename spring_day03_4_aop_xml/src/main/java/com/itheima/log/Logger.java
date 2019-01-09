package com.itheima.log;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    public void before() {
        System.out.println("保存之前执行");
    }

    public void around(ProceedingJoinPoint pjb) {

        try {

            System.out.println("前置 Logger 类中的 aroundPrintLog 方法开始记录日志了");
            pjb.proceed();
            System.out.println("后置 Logger 类中的 aroundPrintLog 方法开始记录日志了");
        }catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常 Logger 类中的 aroundPrintLog 方法开始记录日志了");

        } finally {
            System.out.println("最终 Logger 类中的 aroundPrintLog 方法开始记录日志了");
        }

    }
}
