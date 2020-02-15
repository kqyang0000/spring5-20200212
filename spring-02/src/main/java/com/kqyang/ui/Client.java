package com.kqyang.ui;

import com.kqyang.dao.IAccountDao;
import com.kqyang.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);

    }
}
