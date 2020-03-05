package com.kqyang.utils;

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
}
