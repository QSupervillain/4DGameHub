package com.cxk.controller;

import com.cxk.pojo.GmNews;
import com.cxk.service.Impl.NewsImplA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/21 1:47
 * @Description：
 */
@Controller
public class NewsControllerA {
    @Autowired
    private NewsImplA newsImplA;

    @RequestMapping("/loadNewsALl")
    public String loadNewsALl(Model model){
        System.out.println("加载新闻中。。。。。");
        Map<String,Object>newsCondition=null;
        List<GmNews>gmNewsList=newsImplA.showConditionNewsAll(newsCondition);
        model.addAttribute("gmNewsList",gmNewsList);
        return "news-list";
    }

    @RequestMapping(value = "/ImgPreview")
    public String imgPreview(Model model,@RequestParam String imgSrc){
        System.out.println("进入ImgPreview");
        System.out.println("图片SRC："+imgSrc);
        model.addAttribute("imgSrc",imgSrc);
        return "news-img-preview";
    }

    @RequestMapping(value = "/PagePreview")
    public String pagePreview(Model model,@RequestParam String News_id){
        System.out.println("进入PagePreview");
        System.out.println("要预览的页面："+News_id);
        Map<String,Object>newsCondition=null;
        newsCondition.put("news_id",Integer.valueOf(News_id));
        List<GmNews>gmNewsList=newsImplA.showConditionNewsAll(newsCondition);
        model.addAttribute("newsCintent",gmNewsList.get(0).getNews_cintent());
        return "news-page -preview";
    }
}
