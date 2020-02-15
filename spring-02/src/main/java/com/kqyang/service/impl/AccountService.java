package com.kqyang.service.impl;


import com.kqyang.dao.IAccountDao;
import com.kqyang.dao.impl.AccountDao;
import com.kqyang.service.IAccountService;

public class AccountService implements IAccountService {
    private IAccountDao accountDao = new AccountDao();

    public void save() {
        accountDao.save();
    }
}
