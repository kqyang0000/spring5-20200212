package com.kqyang;

import com.kqyang.factory.BeanFactory;
import com.kqyang.service.IAccountService;

public class JdbcDemo2 {

    public static void main(String[] args) {
        IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
        accountService.save();
    }
}
