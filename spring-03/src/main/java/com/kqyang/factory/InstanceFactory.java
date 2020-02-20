package com.kqyang.factory;

import com.kqyang.service.IAccountService;
import com.kqyang.service.impl.AccountService;

public class InstanceFactory {
    public IAccountService getAccountService() {
        return new AccountService();
    }
}
