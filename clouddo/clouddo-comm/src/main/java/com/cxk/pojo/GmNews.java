package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (GmNews)实体类
 *
 * @author makejava
 * @since 2019-09-10 09:23:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GmNews implements Serializable {
    private static final long serialVersionUID = -31619426772787876L;
    //新闻ID
    private Integer news_id;
    //新闻标题
    private String news_title;
    //新闻预览图
    private String news_preview_img;
    //新闻分类ID
    private Integer news_typeid;
    //新闻发布日期
    private Date news_date;
    //新闻浏览人数
    private Integer news_pageview;
    //新闻概要
    private String news_brief;
    //新闻内容
    private String news_cintent;

}