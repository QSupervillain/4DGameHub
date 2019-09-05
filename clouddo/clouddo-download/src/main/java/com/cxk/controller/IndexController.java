package com.cxk.controller;

import com.cxk.pojo.DownLoad;
import com.cxk.pojo.GameType;
import com.cxk.service.DownLoadService;
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

    @Autowired
    private DownLoadService downLoadService;

    @RequestMapping("/index")
    public String index() {
        List<GameType> type = gameTypeService.getAll();
        for (GameType gameType : type) {
            System.out.println("gameType = " + gameType);
        }
        List<DownLoad> downLoad = downLoadService.getAll();
        for (DownLoad load : downLoad) {
            System.out.println("load = " + load);
        }
        return "首页的展示结果";
    }

}
