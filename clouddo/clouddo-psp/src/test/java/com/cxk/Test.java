package com.cxk;

import com.cxk.pojo.Psp;
import com.cxk.pojo.PspName;
import com.cxk.pojo.PspType;
import com.cxk.service.PspNameService;
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
    @Autowired
    private PspNameService pspNameService;
    @org.junit.Test
    public void aa(){
        List<PspType> list = typeService.shoAll();
        List<Psp> fenye = pspService.fenye(2);
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
        Psp details = pspService.details(3);
        String[] split = details.getPsp_image().split("#");
        List imglist=new ArrayList();
        for (String a:split){
            imglist.add(a);
        }
        System.out.println(imglist);
    }
    @org.junit.Test
    public void cc(){
        List<Psp> fenye = pspService.fenye(2);
        System.out.println(fenye);
    }
    @org.junit.Test
    public void dd(){
        List<PspName> pspNames = pspNameService.pspnamelist();
        System.out.println(pspNames);
    }
    @org.junit.Test
    public void ee(){
        List<Psp> showbytypeid = pspService.showbytypeid(1, 2);
        System.out.println(showbytypeid);
    }
}