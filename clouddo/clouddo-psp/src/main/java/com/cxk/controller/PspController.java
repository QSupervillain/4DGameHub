package com.cxk.controller;

import com.cxk.pojo.Psp;
import com.cxk.pojo.PspType;
import com.cxk.service.PspService;
import com.cxk.service.PspTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/5 19:33
 * @Description：
 */
@Controller
public class PspController {
    @Autowired
    private PspService pspService;
    @Autowired
    private PspTypeService pspTypeService;
    @RequestMapping("/index")
    public String index(Model model) {
        List<PspType> list = pspTypeService.shoAll();
        List<Psp> fenye = pspService.fenye();
        for ( Psp ps:fenye){
            String psp_image = ps.getPsp_image();
            String[] split = psp_image.split("#");
            ps.setPsp_image(split[0]);
            System.out.println(ps);
        }
        model.addAttribute("pspList",fenye);
        return "gl";
    }
    @RequestMapping("/moban")
    public String moban(Model model, @RequestParam("pid")int id){
        System.out.println(id);
        return "gll";
    }


}