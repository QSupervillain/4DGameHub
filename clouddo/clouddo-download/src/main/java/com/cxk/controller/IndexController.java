package com.cxk.controller;

import com.cxk.pojo.DownLoad;
import com.cxk.pojo.GameType;
import com.cxk.service.DownLoadService;
import com.cxk.service.GameTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * gameType_id gametype
     * download_type time、heat、grade
     * download_by  desc asc
     * @return
     */

    @RequestMapping("/index")
    public String index() {
        List<GameType> type = gameTypeService.getAll();
        for (GameType gameType : type) {
            System.out.println("gameType = " + gameType);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("gameType_id", null);
        map.put("download_type", "download_time");
        map.put("download_by", "asc");
        Page<DownLoad> page = PageHelper.startPage(1, 1);
        List<DownLoad> downLoad = downLoadService.getAll(map);
        List<DownLoad> all = downLoadService.getAll(map);

        return "首页的展示结果";
    }

}
