package com.cxk;

import com.cxk.pojo.*;
import com.cxk.service.PpService;
import com.cxk.service.ScService;
import com.cxk.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
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
    @Autowired
    private PpService ppService;
    @Autowired
    private ScService scService;
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
    @org.junit.Test
    public void dd(){
        User user=new User();
        user.setUser_pwd("1233456");
        user.setUser_id(2);
        int update = userService.update(user);
        System.out.println(update);
    }
    @org.junit.Test
    public void ee(){
        List<Psp> psplist = ppService.pplist();
        System.out.println(psplist);
    }
    @org.junit.Test
    public void ff(){
        Date date = new Date();
    }
    @org.junit.Test
    public void gg(){
        List<PspName> namelist = ppService.namelist();
        System.out.println(namelist);
    }
    @org.junit.Test
    public void hh(){
        Psp ppbyid = ppService.Ppbyid(1);
        System.out.println(ppbyid);
    }
    @org.junit.Test
    public void ii(){
        String sctypename = scService.sctypename(1);
        System.out.println(sctypename);
    }
    @org.junit.Test
    public void jj(){
        Market mk=new Market();
        mk.setGame_image("11");
        mk.setGame_time(new Date());
        mk.setGame_status(0);
        mk.setAccount_id(213);
        mk.setGame_describe("dsa");
        mk.setGame_id(321);
        mk.setGame_QQ(23);
        mk.setType_id(2);
        BigDecimal a=new BigDecimal(2);
        mk.setGame_money(a);
        mk.setGame_title("dsa");
        mk.setGame_region("dsa");
        int addmk = scService.addmk(mk);
        System.out.println(addmk);
    }
    @org.junit.Test
    public void kk(){
        Market showmk = scService.showmk(1);
        System.out.println(showmk);
    }
    @org.junit.Test
    public void ll(){
        Market mk=new Market();
        mk.setGame_id(1);
        mk.setType_id(2);
        mk.setGame_status(0);
        int updatemk = scService.updatemk(mk);
        System.out.println(updatemk);
    }
}