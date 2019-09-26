package com.cxk.service.Impl;

import com.cxk.dao.UserDao;
import com.cxk.pojo.User;
import com.cxk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/15 22:10
 * @Description：
 */
@Service
public class UserDaoImpl implements UserService {
    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public List<User> showUser() {
        return userDao.showUser();
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public User showbyid(int id) {
        return userDao.showbyid(id);
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int delet(int id) {
        return userDao.delet(id);
    }

    @Override
    public List<User> mohuuser(String name) {
        return userDao.mohuuser(name);
    }
}