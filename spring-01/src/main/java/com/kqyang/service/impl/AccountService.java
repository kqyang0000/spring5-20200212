package com.kqyang.service.impl;

import com.kqyang.dao.IAccountDao;
import com.kqyang.factory.BeanFactory;
import com.kqyang.service.IAccountService;

public class AccountService implements IAccountService {
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    public void save() {
        accountDao.save();
    }
}
