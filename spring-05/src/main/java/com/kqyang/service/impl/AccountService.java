package com.kqyang.service.impl;


import com.kqyang.dao.IAccountDao;
import com.kqyang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * 用于创建bean
 *
 * @Component： 将对象放置到容器中
 */
@Component
public class AccountService implements IAccountService {

    public AccountService() {
        System.out.println("构造方法init");
    }

    /**
     * @Autowired表示为自动按照类型注入
     *
     * a.如果按类型匹配到一个时，直接注入
     * b.如果匹配到多个时，会按照变量名称进行匹配
     * c.否则会抛出异常
     *
     * @Qualifier注解
     *      作用：在按照类型匹配的基础上再按照名称匹配
     *      注意：在给类成员注入时不能单独使用，在给方法参数注入时可以单独使用
     * @Resource注解：
     *      作用：直接按照bean的id注入
     *      属性：name="beanId"
     *
     * 以上三种方式都可以注入bean类型的数据，但基本类型和String类型不能通过上述注解实现，
     * 集合类型的注入只能通过xml方式注入
     *
     * @Value注解：
     *      作用：基本类型和String类型注入，可以使用${}  SpEL表达式
     *
     *
     *
     *
     * 用于改变作用范围的注解：（默认Singleton）
     * @Scope
     *      常用值：Singleton  prototype
     *
     *
     * 与生命周期相关的注解：
     * @PreDestroy
     *      用于指定销毁方法
     * @PostConstruct
     *      用于指定初始化方法
     */
    @Autowired
    @Qualifier("accountDao1")
    private IAccountDao accountDao1;

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void des(){
        System.out.println("destroy");
    }

    public void save() {
        accountDao1.save();
    }
}
