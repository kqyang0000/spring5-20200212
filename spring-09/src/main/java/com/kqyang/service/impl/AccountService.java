package com.kqyang.service.impl;


import com.kqyang.dao.IAccountDao;
import com.kqyang.domain.Account;
import com.kqyang.service.IAccountService;
import com.kqyang.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * 用于创建bean
 *
 * @Component： 将对象放置到容器中
 */
@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private TransactionManager transactionManager;

    public List<Account> findAll() throws SQLException {
        return accountDao.findAll();
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public void save(Account account) {
        accountDao.save(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(int id) {
        accountDao.delete(id);
    }

    public void transfer(String sourceName, String targetName, float money) {
        try {
            //1.开启事物
            transactionManager.beginTransation();
            //2.执行操作
            Account source = accountDao.findByName(sourceName);
            Account target = accountDao.findByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao.update(source);
            accountDao.update(target);
            //3.提交事物
            transactionManager.commit();
            //4.返回结果
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            e.printStackTrace();
        } finally {
            //6.释放连接
            transactionManager.release();
        }
    }
}
