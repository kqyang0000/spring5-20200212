package com.kqyang.dao.impl;


import com.kqyang.dao.IAccountDao;
import com.kqyang.domain.Account;
import com.kqyang.util.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public class AccountDao implements IAccountDao {

    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Account findById(int id) {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "select * from account where id = ? ", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void save(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "update account set name = ?, money = ? where id = ? ", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "delete from account where id = ? ", id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String accountName) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(), "select * from account where name = ? ", new BeanListHandler<Account>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("数据不唯一");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
