package com.cxk.dao;

import com.cxk.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface VideoDao {
    /**
     * 测试查询全部
     * @return
     */
    public List<Video> findAll();

    /**
     * 分页显示原创视频
     */
    public List<Video> pageOriginalVideo(int video_type);
    /**
     * 根据点击相应视屏进入对应视屏详情播放页
     */
    public List<Video> videoDescribe(int video_id);

}
