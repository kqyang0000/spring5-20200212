package com.kqyang.service.impl;


import com.kqyang.dao.IAccountDao;
import com.kqyang.domain.Account;
import com.kqyang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * 用于创建bean
 *
 * @Component： 将对象放置到容器中
 */
@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

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
}
