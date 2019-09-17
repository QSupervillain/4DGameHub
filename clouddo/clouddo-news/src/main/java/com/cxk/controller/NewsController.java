package com.cxk.controller;

import com.cxk.pojo.GmNews;
import com.cxk.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/10 9:49
 * @Description：
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @RequestMapping("/byid")
    public String load(Model model, @RequestParam(value = "newsID") int newsID){
        GmNews news=newsService.getNewsByID(newsID);
        System.out.println("新闻标题："+news.getNews_title());
        model.addAttribute("news",news);
        return "template";
    }
}
