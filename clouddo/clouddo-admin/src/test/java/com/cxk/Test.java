package com.cxk;

import com.cxk.pojo.User;
import com.cxk.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/5 20:36
 * @Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private UserService userService;
    @org.junit.Test
    public void aa(){
        List<User> users = userService.showUser();
        for (User u:users){
            System.out.println(u);
        }
    }
    @org.junit.Test
    public void bb(){
        User u=new User();
        u.setUser_id(1);
        u.setUser_phone("222222");
        int update = userService.update(u);
        System.out.println(update);
    }
    @org.junit.Test
    public void cc(){
        User showbyid = userService.showbyid(1);
        System.out.println(showbyid);
    }
}