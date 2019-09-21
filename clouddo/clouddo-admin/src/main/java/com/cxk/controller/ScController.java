package com.cxk.controller;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.cxk.pojo.Market;
import com.cxk.pojo.ScType;
import com.cxk.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/20 20:35
 * @Description：
 */
@Controller
public class ScController {
    @Autowired
    private ScService scService;
    @RequestMapping("/scindex")
    public String scindex(Model model){
        List<Market> mklist = scService.mklist();
        model.addAttribute("mklist",mklist);
        return "sc-list";
    }
    @RequestMapping("/addsc")
    public String addsc(Model model){
        List<ScType> sctypelist = scService.sctypelist();
        model.addAttribute("sctypelist",sctypelist);
        return "sc-add";
    }
    @PostMapping("/addscok")
    @ResponseBody
    public void addscok(Market market,@RequestParam("image")String image){
        System.out.println(image);
        com.jcraft.jsch.Session session = JschUtil.getSession("47.102.198.5", 22, "root", "springboot2.0");/*("47.102.198.5", 22, "root", "springboot2.0");*/
        Sftp sftp = JschUtil.createSftp(session);
        market.setGame_status(0);
        Date date = new Date();
        market.setGame_time(date);
        market.setGame_image("dsa");
      //  scService.addmk(market);
        //Sftp video_imgs = sftp.put("C:\\Users\\Zeng\\Desktop\\image\\"+video_img.substring(12), "/opt/static/image/");
    }
    @RequestMapping("/showmk")
    public String showmk(@RequestParam("id")int id,Model model){
        Market showmk = scService.showmk(id);
        List<ScType> sctypelist = scService.sctypelist();
        model.addAttribute("sctypelist",sctypelist);
        model.addAttribute("showmk",showmk);
        return "sc-edit";
    }
    @RequestMapping("/updatemk")
    @ResponseBody
    public void updatemk(Market market){
        scService.updatemk(market);
    }
}