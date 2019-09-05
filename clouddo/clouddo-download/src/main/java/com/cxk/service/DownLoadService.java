package com.cxk.service;

import com.cxk.pojo.DownLoad;

import java.util.List;
import java.util.Map;

public interface DownLoadService {

    /**
     * 获取全部游戏
     *
     * @return
     */
    List<DownLoad> getAll(Map<String, Object> map);

}
