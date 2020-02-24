package com.kqyang;

import com.kqyang.domain.Account;
import com.kqyang.service.IAccountService;
import config.AccountConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * @ContextConfiguration() locations: 指定xml文件位置表示在类路径下，加上classpath关键字
 * classes: 指定注解类所在位置
 *
 * 细节：当我们用Spring 5.x版本以上时，需要junit 4.12+版本
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AccountConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService accountService;

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
