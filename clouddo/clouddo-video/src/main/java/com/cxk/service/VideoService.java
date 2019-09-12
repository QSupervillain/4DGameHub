package com.cxk.service;

import com.cxk.pojo.Video;

import java.util.List;
public interface VideoService {
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
    /**
     * 侧边栏显示8条热门视屏链接
     * @return
     */
    public List<Video>  sidebarVideo();
}
