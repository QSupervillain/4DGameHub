package com.cxk.controller;

import com.cxk.pojo.GameType;
import com.cxk.service.GameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/4 23:55
 * @Description：
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private GameTypeService gameTypeService;

    @RequestMapping("/index")
    public String index() {
        List<GameType> all = gameTypeService.getAll();
        for (GameType gameType : all) {
            System.out.println("gameType = " + gameType);
        }
        return "首页的展示结果";
    }
}
