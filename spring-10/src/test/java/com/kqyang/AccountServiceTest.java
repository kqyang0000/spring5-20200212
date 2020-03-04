package com.kqyang;

import com.kqyang.factory.BeanFactory;
import com.kqyang.service.IAccountService;
import config.AccountConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ContextConfiguration() locations: 指定xml文件位置表示在类路径下，加上classpath关键字
 * classes: 指定注解类所在位置
 * <p>
 * 细节：当我们用Spring 5.x版本以上时，需要junit 4.12+版本
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AccountConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void testTransfer() {
        IAccountService accountService = beanFactory.getAccountService();
        accountService.transfer("aaa", "bbb", 100f);
    }
}
