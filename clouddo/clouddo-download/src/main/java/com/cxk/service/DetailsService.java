package com.cxk.service;

import com.cxk.pojo.Details;

public interface DetailsService {

    /**
     * 根据游戏 ID 找到 游戏详情数据
     *
     * @return
     */
    Details selById(Integer id);

}
