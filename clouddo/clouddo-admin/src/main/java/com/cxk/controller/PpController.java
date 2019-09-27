package com.cxk.controller;

import com.cxk.pojo.Psp;
import com.cxk.pojo.PspName;
import com.cxk.service.PpService;
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
 * @Date ：2019/9/18 11:11
 * @Description：
 */
@Controller
public class PpController {
    @Autowired
    private PpService ppService;
    @RequestMapping("/ppindex")
    public String pspindex(Model model,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size){
        PageHelper.startPage(start,size,"psp_id asc");
        List<Psp> pplist = ppService.pplist();
        PageInfo<Psp> page = new PageInfo<>(pplist);
        model.addAttribute("pplist",page);
        return "pp-list";
    }
    @RequestMapping("/mohu")
    public String mohu(Model model,@RequestParam(value = "name")String name,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size){
        PageHelper.startPage(start,size);
        List<Psp> pplist = ppService.mohu(name);
        PageInfo<Psp> page = new PageInfo<>(pplist);
        model.addAttribute("pplist",page);
        return "pp-list";
    }
    @RequestMapping("/addpp")
    public String add(Model model){
        List<PspName> namelist = ppService.namelist();
        model.addAttribute("namelist",namelist);
        return "pp-add";
    }
    @PostMapping("/addppok")
    public ModelAndView addok( Psp psp, @RequestParam MultipartFile[] image, ModelAndView model) throws Exception{
        psp.setPsp_date(new Date());
        StringBuffer pp_image=new StringBuffer();
        System.out.println(psp);
        for (MultipartFile file : image) {
            long totalMilliSeconds = System.currentTimeMillis();
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
                pp_image.append("http://47.102.198.5:26666/images/" + totalMilliSeconds + ".jpg#");
            }
        }
        psp.setPsp_image(pp_image.toString());
        psp.setPsp_authoridid(3);
        ppService.addpp(psp);
        model.addObject("successful", "1");
        model.setViewName("pp-add");
        return model;
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
    @RequestMapping("/updatppeok")
    @ResponseBody
    public void updateppok(Psp psp){
        int updatepp = ppService.updatepp(psp);
    }
}