package com.cxk.dao;

import com.cxk.pojo.Details;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailsDao {

    /**
     * 根据游戏 ID 找到 游戏详情数据
     * @return
     */
    Details selById(Integer id);

}
