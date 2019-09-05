package com.cxk.util;

import com.cxk.pojo.DownLoad;
import com.cxk.service.DownLoadService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/5 19:48
 * @Description：下载分页小工具
 */
public class DownLoadPageHelper {

    @Autowired
    private static DownLoadService downLoadService;

    public static List<DownLoad> downLoads(String gameType_id, String download_type,String download_by,int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("gameType_id", gameType_id);
        map.put("download_type", download_type);
        map.put("download_by", download_by);

        Page<DownLoad> page = PageHelper.startPage(pageNum, pageSize);
        List<DownLoad> downLoad = downLoadService.getAll(map);
        return downLoad;
    }

}