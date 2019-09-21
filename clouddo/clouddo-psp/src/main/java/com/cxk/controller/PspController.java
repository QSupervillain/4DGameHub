package com.cxk.controller;

import com.cxk.pojo.Psp;
import com.cxk.pojo.PspName;
import com.cxk.pojo.PspType;
import com.cxk.service.PspNameService;
import com.cxk.service.PspService;
import com.cxk.service.PspTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
    @Autowired
    private PspNameService pspNameService;
    @RequestMapping("/index")
    public String index(Model model,@RequestParam(value = "pid",defaultValue = "1")int id,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) {
        List<PspType> typelist = pspTypeService.shoAll();
        PageHelper.startPage(start,size,"psp_id asc");
        List<Psp> fenye = pspService.fenye(id);
        List<PspName> namelist = pspNameService.pspnamelist();
        for ( Psp ps:fenye){
            String psp_image = ps.getPsp_image();
            String[] split = psp_image.split("#");
            ps.setPsp_image(split[0]);
        }
        PageInfo<Psp> page = new PageInfo<>(fenye);
        model.addAttribute("namelist",namelist);
        model.addAttribute("pspList",page);
        model.addAttribute("typelist",typelist);
        model.addAttribute("id",id);
        return "gl";
    }
    @RequestMapping("/moban")
    public String moban(Model model, @RequestParam("pid")int id){
        Psp details = pspService.details(id);
        String[] split = details.getPsp_image().split("#");
        String[] split1 = details.getPsp_description().split("#");
        List imglist = new ArrayList();
        List deslist = new ArrayList();
        for (String a:split){
            imglist.add(a);
        }
        for (String b:split1){
            deslist.add(b);
        }
        model.addAttribute("imglist",imglist);
        model.addAttribute("deslist",deslist);
        model.addAttribute("details",details);
        return "gll";
    }
    @RequestMapping("/index2")
    public String index2(Model model,@RequestParam(value = "pid",defaultValue = "1")int id,@RequestParam(value = "type",defaultValue = "2") int type,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) {
        List<PspType> typelist = pspTypeService.shoAll();
        PageHelper.startPage(start,size,"psp_id asc");
        List<Psp> showbytypeid = pspService.showbytypeid(id, type);
        List<PspName> namelist = pspNameService.pspnamelist();
        for ( Psp ps:showbytypeid){
            String psp_image = ps.getPsp_image();
            String[] split = psp_image.split("#");
            ps.setPsp_image(split[0]);
        }
        PageInfo<Psp> page = new PageInfo<>(showbytypeid);
        model.addAttribute("namelist",namelist);
        model.addAttribute("pspList",page);
        model.addAttribute("typelist",typelist);
        model.addAttribute("id",id);
        return "gl";
    }

}