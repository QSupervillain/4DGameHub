package com.cxk.dao;

import com.cxk.pojo.DownLoad;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DownLoadDao {

    /**
     * 获取全部游戏
     * @return
     */
    List<DownLoad> getAll();

}
