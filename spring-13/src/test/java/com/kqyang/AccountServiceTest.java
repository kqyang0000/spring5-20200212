package com.kqyang;

import com.kqyang.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ContextConfiguration() locations: 指定xml文件位置表示在类路径下，加上classpath关键字
 * classes: 指定注解类所在位置
 * <p>
 * 细节：当我们用Spring 5.x版本以上时，需要junit 4.12+版本
 */
public class AccountServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.deleteAccount();
    }
}
