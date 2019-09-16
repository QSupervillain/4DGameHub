package com.cxk.dao;

import com.cxk.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/15 21:29
 * @Description：
 */
@Mapper
public interface UserDao {
    public List<User> showUser();
    public int update(User user);
    public User showbyid(int id);
}