package com.kqyang.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

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
         * 基于子类：
         *      涉及的类：Enhancer
         *      提供方：第三方cglib库
         *      如何创建动态代理对象：
         *          使用Enhancer的create()方法
         *      创建代理对象的要求：
         *          被代理类不能是最终类
         *      create方法参数：
         *          Class：字节码
         *              指定被代理对象的字节码
         *          Callback：用于提供增强的代码
         *              让我们如何写代理。一般都是该接口子接口实现类，通常情况下都是写一个匿名内部类，此接口实现类谁用谁写。
         *
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何接口方法都会经过该方法
             *
             * @param proxy  代理对象的饮用
             * @param method 当前执行的方法
             * @param args   当前执行方法所需的参数
             * @param methodProxy   当前执行方法的代理对象
             * @return 和被代理对象方法有相同的返回值
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
        cglibProducer.saleProduct(12000f);
    }
}
