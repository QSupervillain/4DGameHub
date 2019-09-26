package com.cxk.controller;

import com.cxk.pojo.User;
import com.cxk.service.UserService;
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
import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/15 21:51
 * @Description：
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/adminlist")
    public String admin(Model model,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size){
        PageHelper.startPage(start,size,"user_id");
        List<User> userlist = userService.showUser();
        PageInfo<User> page = new PageInfo<>(userlist);
        model.addAttribute("userlist",page);
        return "admin-list";
    }
    @RequestMapping("/update")
    public String update(@RequestParam("id") int id,Model model){
        User u = userService.showbyid(id);
        model.addAttribute("user",u);
        return "admin-edit";
    }
    @RequestMapping("/updateok")
    @ResponseBody
    public void updateok(User user){
        userService.update(user);
    }
    @RequestMapping("/add")
    public String add(){
        return "admin-add";
    }
    @PostMapping("/addok")
    public ModelAndView add(User user, @RequestParam MultipartFile[] image, ModelAndView model) throws Exception{
        long totalMilliSeconds = System.currentTimeMillis();
        for (MultipartFile file : image) {
            //判断文件非空，上传
            if (!file.isEmpty()) {
                System.out.println("我进来了---------------------------------------------------------------");
                //1、连接ftp服务器
                FTPClient ftpClient = new FTPClient();
                ftpClient.setConnectTimeout(100000);
                ftpClient.connect("47.102.198.5", 21);
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
        String img = "http://47.102.198.5:26666/images/" + totalMilliSeconds + ".jpg";
        user.setUser_image(img);
        userService.add(user);
        model.addObject("successful", "1");
        model.setViewName("admin-add");

        return model;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam("id") int id){
        userService.delet(id);
    }
    @RequestMapping("/usermohu")
    public String mohu(Model model,@RequestParam(value = "name")String name,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size){
        PageHelper.startPage(start,size);
        List<User> pplist = userService.mohuuser(name);
        PageInfo<User> page = new PageInfo<>(pplist);
        model.addAttribute("userlist",page);
        return "admin-list";
    }
}