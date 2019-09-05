package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/5 11:00
 * @Description：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DownLoad implements Serializable {

    private static final long serialVersionUID = -4532241936033527116L;
    private Integer download_id;                       //唯一标识ID
    private Integer gametype_id;                       //游戏类型ID   一对多
    private Integer details_id;                        //游戏详情ID   一对一
    private String download_name;                      //游戏名称
    private String download_image;                     //游戏图片
    private Integer download_heat;                     //游戏热度
    private String download_language;                  //游戏语言
    private String download_grade;                     //游戏评分
    private Date download_time;                        //发布时间
    private String download_platform;                  //运行平台
    private String download_release;                   //发行开发
    private String download_size;                      //游戏大小 MB、GB
    private String download_network;                   //官方网站  www.
    private String download_label;                     //游戏标签：奇幻  中世纪  独立
    private int download_download;                     //默认0,没用资源，不可以下载 ，1 可以下载 static/download/ + download_name名称

}
