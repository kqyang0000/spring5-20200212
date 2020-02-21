package com.kqyang.dao.impl;


import com.kqyang.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao1 implements IAccountDao {
    public void save() {
        System.out.println("保存成功1");
    }
}
