package com.cxk;

import com.cxk.pojo.PspType;
import com.cxk.service.PspTypeService;
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
    private PspTypeService typeService;

    @org.junit.Test
    public void aa(){
        List<PspType> list = typeService.shoAll();
        System.out.println(list.get(1));
    }
}