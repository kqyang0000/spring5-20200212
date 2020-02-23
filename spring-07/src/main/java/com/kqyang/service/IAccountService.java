package com.kqyang.service;

import com.kqyang.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    List<Account> findAll() throws SQLException;

    Account findById(int id);

    void save(Account account);

    void update(Account account);

    void delete(int id);
}
