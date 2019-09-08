package com.cxk.controller;

import com.cxk.pojo.PspType;
import com.cxk.service.PspTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/5 19:33
 * @Description：
 */
@Controller
public class PspController {
    @Autowired
    private PspTypeService pspTypeService;
    @RequestMapping("/index")
    public String index() {
        List<PspType> list = pspTypeService.shoAll();
        for (PspType ps:list){
            System.out.println(ps);
        }
        return "spsindex";
    }


}