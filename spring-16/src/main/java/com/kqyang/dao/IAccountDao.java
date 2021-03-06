package com.kqyang.dao;

import com.kqyang.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {
    List<Account> findAll() throws SQLException;

    Account findById(int id);

    void save(Account account);

    void update(Account account);

    void delete(int id);

    /**
     * 通过名称查询用户
     *
     * @param accountName
     * @return
     */
    Account findByName(String accountName);
}
