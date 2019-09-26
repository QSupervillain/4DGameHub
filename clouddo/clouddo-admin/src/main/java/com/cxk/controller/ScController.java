package com.cxk.controller;

import com.cxk.pojo.Market;
import com.cxk.pojo.ScType;
import com.cxk.service.ScService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.io.PrintWriter;
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
    public String scindex(Model model,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size){
        PageHelper.startPage(start,size,"game_id");
        List<Market> mklist = scService.mklist();
        PageInfo<Market> page = new PageInfo<>(mklist);
        model.addAttribute("mklist",page);
        return "sc-list";
    }
    @RequestMapping("/addsc")
    public String addsc(Model model){
        List<ScType> sctypelist = scService.sctypelist();
        model.addAttribute("sctypelist",sctypelist);
        return "sc-add";
    }
    @PostMapping("/addscok")
    public ModelAndView addscok(Market market, @RequestParam MultipartFile[] image, ModelAndView model) throws Exception{
        System.out.println("WenBinZeng"+image);
//        String game_title =(String) mp.get("game_title");
        System.out.println(market);
        String typename = scService.sctypename(market.getType_id());
        String game_region = market.getGame_region();
        market.setGame_region(typename+"/"+game_region);
        long totalMilliSeconds = System.currentTimeMillis();
        for (MultipartFile file : image) {
            //判断文件非空，上传
            if (!file.isEmpty()) {
                System.out.println("我进来了---------------------------------------------------------------");
                //1、连接ftp服务器
                FTPClient ftpClient = new FTPClient();
                ftpClient.setConnectTimeout(100000);
                ftpClient.connect("47.102.198.5", 21);
                //2、登录ftp服务器
                ftpClient.login("ftpuser", "root");
                ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
                //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                InputStream is = file.getInputStream();
                //4、上传文件
                // 1）指定上传目录
                ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/");
                //2）指定文件类型
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //第一个参数：文件在远程服务器的名称
                // 第二个参数：文件流
                System.out.println(totalMilliSeconds);
                ftpClient.storeFile( totalMilliSeconds+ ".jpg", is);
                //5、退出登录
                ftpClient.logout();
            }
        }
        String sc_imgg = "http://47.102.198.5:26666/images/" + totalMilliSeconds + ".jpg";
        market.setGame_time(new Date());
        market.setGame_image(sc_imgg);
        scService.addmk(market);
            //判断文件非空，上传
//        market.setGame_status(0);
//        Date date = new Date();
//        market.setGame_time(date);
//        market.setGame_image("dsa");
      //  scService.addmk(market);
        //Sftp video_imgs = sftp.put("C:\\Users\\Zeng\\Desktop\\image\\"+video_img.substring(12), "/opt/static/image/");
        model.addObject("successful", "1");
        model.setViewName("sc-add");
        return model;
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
    @RequestMapping("/deletesc")
    @ResponseBody
    public void deletesc(@RequestParam("id")int id){
        scService.deletesc(id);
    }
    @RequestMapping("/mkmohu")
    public String mohu(Model model,@RequestParam(value = "name")String name,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size){
        PageHelper.startPage(start,size);
        List<Market> pplist = scService.mkmohu(name);
        PageInfo<Market> page = new PageInfo<>(pplist);
        model.addAttribute("mklist",page);
        return "sc-list";
    }
}