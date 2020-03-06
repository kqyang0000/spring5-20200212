package com.kqyang.service.impl;


import com.kqyang.dao.IAccountDao;
import com.kqyang.domain.Account;
import com.kqyang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


/**
 * 用于创建bean
 *
 * @Component： 将对象放置到容器中
 */
@Service
@Transactional
public class AccountService implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public List<Account> findAll() throws SQLException {
        return accountDao.findAll();
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public void save(Account account) {
        accountDao.save(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(int id) {
        accountDao.delete(id);
    }

    public void transfer(String sourceName, String targetName, float money) {
        System.out.println("aaaa");
        Account source = accountDao.findByName(sourceName);
        Account target = accountDao.findByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.update(source);
        accountDao.update(target);
        int i = 1/0;
    }
}
