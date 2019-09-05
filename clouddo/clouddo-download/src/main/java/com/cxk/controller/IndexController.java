package com.cxk.controller;

import com.cxk.pojo.DownLoad;
import com.cxk.pojo.GameType;
import com.cxk.service.DownLoadService;
import com.cxk.service.GameTypeService;
import com.cxk.util.DownLoadPageHelper;
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
        List<DownLoad> downLoads = DownLoadPageHelper.downLoads(null, "download_time", "desc", 1, 1);

        return "首页的展示结果";
    }

}
