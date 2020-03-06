package com.kqyang.util;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

//@Component
//@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.kqyang.service.impl.*.*(..)))")
    public void pt() {
    }

    public void beginTransation() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object obj = null;
        try {
            Object[] args = pjp.getArgs();
            this.beginTransation();
            obj = pjp.proceed(args);
            this.commit();
        } catch (Throwable t) {
            this.rollback();
            new RuntimeException(t);
        } finally {
            this.release();
        }
        return obj;
    }
}
