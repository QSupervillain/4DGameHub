package com.cxk.util;

import com.cxk.pojo.DownLoad;
import com.cxk.service.DownLoadService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/5 19:48
 * @Description：下载分页小工具
 */
public class DownLoadPageHelper {

    public static List<DownLoad> downLoads(DownLoadService downLoadService, String gameType_id, String download_type, String download_by) {
        Map<String, Object> map = new HashMap<>();
        map.put("gameType_id", gameType_id);
        map.put("download_type", download_type);
        map.put("download_by", download_by);

        List<DownLoad> downLoad = downLoadService.getAll(map);
        return downLoad;
    }

}