package com.itheima.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class Logger {

    @Pointcut("execution(* com.itheima..service.*.*(..))")
    public void pointCut() {}

    @Around("pointCut()")
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
