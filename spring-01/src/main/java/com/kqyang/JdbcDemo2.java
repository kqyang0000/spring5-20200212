package com.kqyang;

import com.kqyang.factory.BeanFactory;
import com.kqyang.service.IAccountService;

public class JdbcDemo2 {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
            accountService.save();
        }
    }
}
