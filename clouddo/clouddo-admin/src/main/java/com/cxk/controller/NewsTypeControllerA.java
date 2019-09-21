package com.cxk.controller;

import com.cxk.pojo.GmNewsType;
import com.cxk.service.NewsTypeServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/18 10:55
 * @Description：
 */
@Controller
public class NewsTypeControllerA {
    @Autowired
    private NewsTypeServiceA newsTypeServiceA;

    /**
     * 显示全部新闻类型
     * @param model
     * @return
     */
    @RequestMapping("/LoadNewsType")
    public String  getNewsType(Model model){
        List<GmNewsType> gmNewsTypeList=newsTypeServiceA.showNewsTypeAll();
        model.addAttribute("gmNewsTypeList",gmNewsTypeList);
        return "news-type-list";
    }

    /**
     * 添加一条新的新闻类型
     * @param uType
     * @return
     */
    @RequestMapping(value = "/AddNewsType",method = RequestMethod.POST)
    @ResponseBody
    public int addNewsType(@RequestParam Map<String,Object> uType){
        String typeName=(String) uType.get("typeName");
        int pd=1;
        List<GmNewsType> gmNewsTypeList=newsTypeServiceA.showNewsTypeAll();
        for (GmNewsType gmNewsType : gmNewsTypeList) {
            if(typeName.equals(gmNewsType.getType_name())){
                pd=-1;
            }
        }
        if(-1!=pd){
            pd=newsTypeServiceA.addNewsType(typeName);
        }
        return pd;
    }

    /**
     * 根据id修改新闻类型名称
     * @param newTypeMap
     * @return
     */
    @RequestMapping(value = "/UpdateNewsType",method = RequestMethod.POST)
    @ResponseBody
    public int updateNewsType(@RequestParam Map<String,Object> newTypeMap){
        int pd=1;
        String typeId=(String)newTypeMap.get("typeId");
        GmNewsType gmNewsTypeC=new GmNewsType();
        gmNewsTypeC.setType_id(Integer.valueOf(typeId));
        gmNewsTypeC.setType_name(((String)newTypeMap.get("typeName")).replace(" ",""));
        System.out.println("/n*******************************");
        System.out.println("id:"+gmNewsTypeC.getType_id());
        System.out.println("name:"+gmNewsTypeC.getType_name());
        List<GmNewsType> gmNewsTypeList=newsTypeServiceA.showNewsTypeAll();
        for (GmNewsType gmNewsType : gmNewsTypeList) {
            if(gmNewsTypeC.getType_name().equals(gmNewsType.getType_name())){
                pd=-1;
            }
        }
        if(-1!=pd){
            pd=newsTypeServiceA.updateNewsType(gmNewsTypeC);
        }
        return pd;
    }


    /**
     * 加载新闻类型表
     * @param model
     * @param typeId
     * @param typeName
     * @return
     */
    @RequestMapping("/UpdateNewsTypeLoad")
    public String getNewsTypeById(Model model,@RequestParam int typeId, String typeName){
        System.out.println("加载中。。。。:");
        System.out.println("ID:"+typeId);
        System.out.println("Name:"+typeName);
        model.addAttribute("typeId",typeId);
        model.addAttribute("typeName",typeName);
        return "news-type-update";
    }


    /**
     * 根据id删除对应数据
     * @param type_id
     * @return
     */
    @RequestMapping(value = "/deleteNewsTypeById",method = RequestMethod.POST)
    @ResponseBody
    public int deleteNewsTypeById(String type_id){
        int pd=0;
        System.out.println("id:"+type_id);
        pd= newsTypeServiceA.deleteNewsTypeByid(Integer.valueOf(type_id));
        return pd;
    }
}
