package com.kqyang.factory;

import com.kqyang.service.IAccountService;
import com.kqyang.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BeanFactory {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private TransactionManager transactionManager;

    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            //1.开启事物
                            transactionManager.beginTransation();
                            //2.执行操作
                            rtValue = method.invoke(accountService, args);
                            //3.提交事物
                            transactionManager.commit();
                            //4.返回结果
                        } catch (Exception e) {
                            //5.回滚操作
                            transactionManager.rollback();
                            e.printStackTrace();
                        } finally {
                            //6.释放连接
                            transactionManager.release();
                        }
                        return rtValue;
                    }
                });
    }
}
