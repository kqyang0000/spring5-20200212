package com.kqyang.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
    public void beforePrintLog() {
        System.out.println("Logger类型的beforePrintLog方法开始记录日志");
    }

    public void afterReturnPrintLog() {
        System.out.println("Logger类型的afterReturnPrintLog方法开始记录日志");
    }

    public void afterThrowingPrintLog() {
        System.out.println("Logger类型的afterThrowingPrintLog方法开始记录日志");
    }

    public void afterPrintLog() {
        System.out.println("Logger类型的afterPrintLog方法开始记录日志");
    }

    /**
     * 环绕通知：
     * Spring框架提供了ProceedingJoinPoint接口供方法调用
     */
    public Object aroundLog(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {
            System.out.println("Logger类型的aroundLog方法开始记录日志");
            Object[] args = joinPoint.getArgs();
            obj = joinPoint.proceed(args);
            System.out.println("Logger类型的aroundLog方法开始记录日志");
            return obj;
        } catch (Throwable t) {
            System.out.println("Logger类型的aroundLog方法开始记录日志");
            throw new RuntimeException(t);
        } finally {
            System.out.println("Logger类型的aroundLog方法开始记录日志");
        }
    }
}
