package com.kqyang.service.impl;

import com.kqyang.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        int i = 1/0;
        return 0;
    }
}
