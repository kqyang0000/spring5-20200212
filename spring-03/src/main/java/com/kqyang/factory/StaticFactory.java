package com.kqyang.factory;

import com.kqyang.service.IAccountService;
import com.kqyang.service.impl.AccountService;

public class StaticFactory {
    public static IAccountService getAccountService() {
        return new AccountService();
    }
}
