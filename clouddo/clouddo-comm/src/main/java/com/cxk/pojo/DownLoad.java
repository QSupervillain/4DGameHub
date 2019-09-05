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
    private Integer id;                 //唯一标识ID
    private Integer typeId;             //游戏类型ID   一对多
    private Integer detailsId;          //游戏详情ID   一对一
    private String name;                //游戏名称
    private String image;               //游戏图片
    private Integer heat;               //游戏热度
    private String language;            //游戏语言
    private String grade;               //游戏评分
    private Date time;                  //发布时间
    private String platform;            //运行平台
    private String release;             //发行开发
    private String size;                //游戏大小 MB、GB
    private String network;             //官方网站  www.
    private String label;               //游戏标签：奇幻  中世纪  独立

}
