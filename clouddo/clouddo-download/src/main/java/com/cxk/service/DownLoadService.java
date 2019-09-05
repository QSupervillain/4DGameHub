package com.cxk.service;

import com.cxk.pojo.DownLoad;

import java.util.List;

public interface DownLoadService {

    /**
     * 获取全部游戏
     * @return
     */
    List<DownLoad> getAll();

}
