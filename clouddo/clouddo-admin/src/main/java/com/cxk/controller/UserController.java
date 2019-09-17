package com.cxk.controller;

import com.cxk.pojo.User;
import com.cxk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String admin(Model model){
        List<User> userlist = userService.showUser();
        model.addAttribute("userlist",userlist);
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
        System.out.println(user.getUser_role());
        userService.update(user);
    }
    @RequestMapping("/add")
    public String add(){
        return "admin-add";
    }
    @RequestMapping("/addok")
    @ResponseBody
    public void add(User user){
        userService.add(user);
    }
}