package com.kqyang;

import com.kqyang.domain.Account;
import com.kqyang.service.IAccountService;
import config.AccountConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceTest {
    private ApplicationContext applicationContext;
    IAccountService accountService;

    @Before
    public void init() {
        applicationContext = new AnnotationConfigApplicationContext(AccountConfiguration.class);
        accountService = (IAccountService) applicationContext.getBean("accountService");
    }

    @Test
    public void testFindAll() throws SQLException {
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account.toString());
        }
    }

    @Test
    public void testFindById() {
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}
