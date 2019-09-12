package com.cxk.controller;

import com.cxk.pojo.DownLoad;
import com.cxk.pojo.GameType;
import com.cxk.service.DownLoadService;
import com.cxk.service.GameTypeService;
import com.cxk.util.DownLoadPageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/4 23:55
 * @Description：
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private GameTypeService gameTypeService;

    @Autowired
    private DownLoadService downLoadService;


    private static String BY_Name = "asc";

    private Logger log = LoggerFactory.getLogger(Log.class);

    /**
     * gameType_id gametype
     * download_type time、heat、grade
     * download_by  desc asc
     *
     * @return
     */

    @RequestMapping("/load")
    public String index(Model model) {
        long l1 = System.currentTimeMillis();

        List<GameType> gameTypeList = gameTypeService.getAll();

        List<DownLoad> downLoadList = DownLoadPageHelper.downLoads(downLoadService, null, "download_time", "desc", 1, 4);
        for (DownLoad downLoad : downLoadList) {
            for (GameType gameType : gameTypeList) {
                if (downLoad.getGametype_id() == gameType.getGameType_id()) {
                    downLoad.setGametype_name(gameType.getGameType_name());
                }
            }
        }
        long l2 = System.currentTimeMillis();
        model.addAttribute("gameTypeList", gameTypeList);
        model.addAttribute("downLoadList", downLoadList);
        System.out.println("总耗时 = " + (l2 - l1));
        return "index4";
    }

    @RequestMapping("/pageHelper")
    @ResponseBody
    public String pageHelper(String id, String type, int pageNum) {
        BY_Name=BY_Name=="asc"?"desc":"asc";
        List<DownLoad> downLoads = DownLoadPageHelper.downLoads(downLoadService, id, type, BY_Name, pageNum, 4);
        for (DownLoad downLoad : downLoads) {
            System.out.println("downLoad = " + downLoad);
        }
        return "success";
    }

}
