package com.cxk;

import com.cxk.pojo.Psp;
import com.cxk.pojo.PspType;
import com.cxk.service.PspService;
import com.cxk.service.PspTypeService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
    @Autowired
    private PspService pspService;

    @org.junit.Test
    public void aa(){
        List<PspType> list = typeService.shoAll();
        List<Psp> fenye = pspService.fenye();
       // System.out.println(list.get(1));
        String image=fenye.get(0).getPsp_image();
       // System.out.println(image);
        String[] split = image.split("#");
        List imglist=new ArrayList();
        for (String a:split){
            imglist.add(a);
        }
        System.out.println(imglist.get(0));
    }
    @org.junit.Test
    public void bb(){
        Psp details = pspService.details(1);
        System.out.println(details);
    }
}