package com.cxk.controller;

import com.cxk.pojo.GmNews;
import com.cxk.pojo.GmNewsType;
import com.cxk.service.Impl.NewsImplA;
import com.cxk.service.NewsTypeServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/21 1:47
 * @Description：
 */
@Controller
public class NewsControllerA {
    @Autowired
    private NewsImplA newsImplA;
    @Autowired
    private NewsTypeServiceA newsTypeServiceA;
    private List<GmNewsType> gmNewsTypeList;

    /**
     * 加载新闻表
     * @param model
     * @param start
     * @param end
     * @param nNtype
     * @param sequence
     * @param fuzzyQuery
     * @return
     * @throws ParseException
     */
    @RequestMapping("/loadNewsALl")
    public String loadNewsALl(Model model,@RequestParam(required=false) String start,String end,
                              String nNtype,String sequence,String fuzzyQuery) throws ParseException {
        System.out.println("加载新闻中。。。。。");
        System.out.println("新闻类型："+nNtype);
        System.out.println("排序："+sequence);
        System.out.println("模糊查询："+fuzzyQuery);
        HashMap<String,Object> newsCondition=judgment(start,end,nNtype,sequence,fuzzyQuery);
        int totalInt =newsImplA.getNewsNumberOfBranches(newsCondition);
        System.out.println("数据总条数："+totalInt);
        if(nNtype==null){
            gmNewsTypeList= newsTypeServiceA.showNewsTypeAll();
        }
        model.addAttribute("gmNewsTypeList",gmNewsTypeList);
        List<GmNews> gmNewsList=newsImplA.showConditionNewsAll(newsCondition);
        model.addAttribute("gmNewsList",gmNewsList);
        /*System.out.println("Jssion:"+gmNewsList);*/
        return "news-list";
    }

    /**
     * 预览图片
     * @param model
     * @param imgSrc
     * @return
     */
    @RequestMapping(value = "/ImgPreview")
    public String imgPreview(Model model,@RequestParam String imgSrc){
        System.out.println("进入ImgPreview");
        System.out.println("图片SRC："+imgSrc);
        model.addAttribute("imgSrc",imgSrc);
        return "news-img-preview";
    }

    /**
     * 预览新闻内容
     * @param model
     * @param News_id
     * @return
     */
    @RequestMapping(value = "/PagePreview")
    public String pagePreview(Model model,@RequestParam String News_id){
        System.out.println("进入PagePreview");
        System.out.println("要预览的页面："+News_id);
        HashMap<String,Object> newsCondition = new HashMap<String, Object>();
        newsCondition.put("news_id",Integer.valueOf(News_id));
        List<GmNews>gmNewsList=newsImplA.showConditionNewsAll(newsCondition);
        model.addAttribute("newsCintent",gmNewsList.get(0).getNews_cintent());
        return "news-page -preview";
    }

   public HashMap<String,Object> judgment(String start,String end,
                        String nNtype,String sequence,String fuzzyQuery) throws ParseException {

        HashMap<String,Object> newsCondition = new HashMap<String, Object>();
        //起始时间
        if(null!=start&&!start.equals("")){
            newsCondition.put("start",new SimpleDateFormat("yyyy-MM-dd").parse(start));
        }
        //结束时间
        if(null!=end&&!end.equals("")){
            newsCondition.put("end",new SimpleDateFormat("yyyy-MM-dd").parse(end));
        }
        //新闻类型
        if(null!=nNtype&&!nNtype.equals("not")){
            newsCondition.put("nNtype",Integer.valueOf(nNtype));
        }
       //排序
        if(null!=sequence&&!sequence.equals("not")){
            newsCondition.put("sequence",sequence);
        }
       //模糊查询标题
        if(null!=fuzzyQuery&&!fuzzyQuery.equals("")){
            newsCondition.put("fuzzyQuery",fuzzyQuery);
        }
        return newsCondition;
   }

    /**
     * 删除数据
     * @param nId
     * @return
     */
   @RequestMapping(value = "/deleteNews",method = RequestMethod.POST)
   @ResponseBody
   public int deleteNews(@RequestParam String[] nId){
       System.out.println("进入");
       System.out.println("id:"+nId[0]);
       List<Integer> list=new ArrayList<Integer>();
       for (String s : nId) {
           list.add(Integer.valueOf(s));
       }
       return newsImplA.updateNewsDaoA(list);
   }

   //新增
    @RequestMapping(value = "/addNews")
    @ResponseBody
    public int addNews(@RequestParam(required=false) String nTitle,String nPreviewImg,
                       String nTypeid, String nBrief,String nCintent) throws Exception {
        System.out.println("进入测试");
        System.out.println("图片路径："+nPreviewImg);
        Map<String,Object> map=disposalData(nTitle,nTypeid,nBrief,nCintent);
        String imgUrl = nPreviewImg.toString();
        String image = imgUrl.substring(imgUrl.lastIndexOf("\\")+1);
        map.put("nPreviewImg","http://47.102.198.5:22222/image/"+image);//图片路径
        System.out.println("标题："+map.get("nTitle"));
        System.out.println("图片路径："+image);
        System.out.println("新闻类型："+map.get("nTypeid"));
        System.out.println("录入时间："+map.get("nDate"));
        System.out.println("点击数："+map.get("nPageview"));
        System.out.println("新闻简介："+map.get("nBrief"));
        System.out.println("新闻内容："+map.get("nCintent"));



        /*newsImplA.addNews(map);*/
        return newsImplA.addNews(map);
    }
    //整理新增数据
    public Map<String,Object> disposalData(String nTitle,String nTypeid, String nBrief,String nCintent) throws Exception {
        HashMap<String,Object> newsCondition = new HashMap<String, Object>();
        newsCondition.put("nTitle",nTitle);//录入新闻标题
        newsCondition.put("nTypeid",Integer.valueOf(nTypeid));//录入新闻类型id
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        newsCondition.put("nDate",dateFormat.format(date));//录入时间
        newsCondition.put("nPageview",0);//录入初始化点击人数
        newsCondition.put("nBrief",nBrief);//录入新闻简介
        newsCondition.put("nCintent",nCintent);//录入新闻内容
        return newsCondition;
    }
    @RequestMapping(value = "/addNewsLoad")
    public String addNewsload(Model model) throws ParseException {
       gmNewsTypeList= newsTypeServiceA.showNewsTypeAll();
        for (GmNewsType type : gmNewsTypeList) {
        }
       model.addAttribute("gmNewsTypeList",gmNewsTypeList);
       return "news-add";
    }

    //新闻修改页面加载
    @RequestMapping(value = "/UpdateNewsLoad")
    public String UpdateNewsLoad(Model model,@RequestParam(required=false) String nId) {
        List<GmNewsType> gmNewsTypeList=newsTypeServiceA.showNewsTypeAll();
        model.addAttribute("gmNewsTypeList",gmNewsTypeList);
        System.out.println("*****************");
        System.out.println("newsID:"+nId);
        HashMap<String, Object> newsCondition = new HashMap<String, Object>();
        newsCondition.put("news_id", Integer.valueOf(nId));
        List<GmNews> gmNewsList = newsImplA.showConditionNewsAll(newsCondition);
        GmNews gmNews = gmNewsList.get(0);
        System.out.println("图片：" + gmNews.getNews_title());
        model.addAttribute(gmNews);
        return "news-update";
    }

    //新闻修改页面加载
    @RequestMapping(value = "/UpdateNews")
    @ResponseBody
    public int UpdateNews(@RequestParam(required=false) String nId,String nTitle,String nPreviewImg,
                          String nTypeid, String nBrief,String nCintent) throws Exception {
        System.out.println("进入UpdateNews");
        System.out.println("ID:"+nId);
        Map<String,Object> map=disposalData(nTitle,nTypeid,nBrief,nCintent);
        String image = nPreviewImg.substring(nPreviewImg.lastIndexOf("\\")+1);
        map.put("nPreviewImg","http://47.102.198.5:22222/image/"+image);//图片路径
        map.put("nId",Integer.valueOf(nId));
        return newsImplA.updateNews(map);
    }


}
