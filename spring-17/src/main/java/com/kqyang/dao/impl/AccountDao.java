package com.kqyang.dao.impl;


import com.kqyang.dao.IAccountDao;
import com.kqyang.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDao implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findById(int id) {
        return jdbcTemplate.query("select * from account where id = ? ", new BeanPropertyRowMapper<Account>(Account.class), id).get(0);
    }

    public void save(Account account) {
        jdbcTemplate.update("insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
    }

    public void update(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ? ", account.getName(), account.getMoney(), account.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from account where id = ? ", id);
    }

    public Account findByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ? ", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accounts == null || accounts.size() == 0) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("数据不唯一");
        }
        return accounts.get(0);
    }
}
