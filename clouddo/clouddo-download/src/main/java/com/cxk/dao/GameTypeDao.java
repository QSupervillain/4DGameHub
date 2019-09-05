package com.cxk.dao;

import com.cxk.pojo.GameType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameTypeDao {

    /**
     *  获取全部游戏类型
     * @return
     */
    List<GameType> getAll();

}
