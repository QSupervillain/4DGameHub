package com.cxk.service;

import com.cxk.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> showUser();
    public int update(User user);
    public User showbyid(int id);
    public int add(User user);
    public int delet(int id);
}
