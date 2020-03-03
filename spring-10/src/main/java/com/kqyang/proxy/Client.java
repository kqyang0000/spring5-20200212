package com.kqyang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 动态代理
         * 特点：字节码随用随创建，随用随加载
         * 作用：不修改源码的基础上对方法进行增强
         * 分类：
         *      基于接口
         *      基于子类
         * 基于接口：
         *      涉及的类：Proxy
         *      提供方：jdk官方
         *      如何创建动态代理对象：
         *          使用Proxy的newProxyInstance()方法
         *      创建代理对象的要求：
         *          被代理类最少实现一个接口，如果没有则不能使用
         *      newProxyInstance方法参数：
         *          ClassLoader（类加载器）
         *              用于加载代理对象字节码，和被代理对象使用相同的类加载器。（固定写法）
         *          Class[]
         *              用于让代理对象与被代理对象有相同方法。（固定写法）
         *          InvocationHandler
         *              让我们如何写代理。一般都是该接口的实现类，通常情况下都是写一个匿名内部类，此接口实现类谁用谁写。
         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                //匿名内部类
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     *
                     * @param proxy  代理对象的饮用
                     * @param method 当前执行的方法
                     * @param args   当前执行方法所需的参数
                     * @return 和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        /**
                         * 提供代码增强
                         */
                        Float money = (Float) args[0];
                        if ("saleProduct".equals(method.getName())) {
                            //匿名内部类要想使用外部的变量，则变量必须加final
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduct(10000f);
    }
}
