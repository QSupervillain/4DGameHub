package com.cxk.service;

import com.cxk.pojo.GameType;

import java.util.List;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/5 0:22
 * @Description：
 */
public interface GameTypeService {

    /**
     *  获取全部游戏类型
     * @return
     */
    List<GameType> getAll();

}
