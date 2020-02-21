package com.kqyang.ui;

import com.kqyang.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /**
     * ApplicationContext：
     *      AnnotationConfigApplicationContext
     *      ClassPathXmlApplicationContext
     *      FileSystemXmlApplicationContext
     * <p>
     * 两个核心容器引发的问题：
     *      单例
     *      ApplicationContext:
     *          在构造核心容器时，创建对象采用立即加载的方式。也即是说，读取完配置文件后，就马上创建配置文件中的对象
     *      多例
     *      BeanFactory:
     *          在构造核心容器时，创建对象采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
     *
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.save();
        applicationContext.close();
    }
}
