package com.cxk.controller;

import com.cxk.pojo.Psp;
import com.cxk.pojo.PspName;
import com.cxk.service.PpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/18 11:11
 * @Description：
 */
@Controller
public class PpController {
    @Autowired
    private PpService ppService;
    @RequestMapping("/ppindex")
    public String pspindex(Model model){
        List<Psp> pplist = ppService.pplist();
        model.addAttribute("pplist",pplist);
        return "pp-list";
    }
    @RequestMapping("/addpp")
    public String add(Model model){
        List<PspName> namelist = ppService.namelist();
        model.addAttribute("namelist",namelist);
        return "pp-add";
    }
    @RequestMapping("/addppok")
    @ResponseBody
    public void addok(Model model,Psp psp){
        ppService.addpp(psp);
    }
    @RequestMapping("/deletepp")
    @ResponseBody
    public void deletepp(@RequestParam("id")int id){
        ppService.deletepp(id);
    }
    @RequestMapping("/updatepp")
    public String updatepp(@RequestParam("id")int id,Model model){
        Psp ppbyid = ppService.Ppbyid(id);
        model.addAttribute("ppbyid",ppbyid);
        List<PspName> namelist = ppService.namelist();
        model.addAttribute("namelist",namelist);
        return "pp-edit";
    }
}