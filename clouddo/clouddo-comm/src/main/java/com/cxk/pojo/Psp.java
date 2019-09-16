package com.cxk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/7 10:38
 * @Description：游戏攻略表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Psp implements Serializable {
    private static final long serialVersionUID = -4532241936033527116L;
    private int psp_id;
    private String psp_title;        //标题
    private String psp_image;        //图片地址
    private String psp_content;      //更多内容
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date psp_date;           //发布时间
    private int psp_authoridid;      //作者ID
    private String psp_source;       //攻略来源
    private int psp_pv;              //浏览数
    private int psp_tpye;            //攻略类型
    private String psp_description;  //详情
    private int psp_pspnameid;       //游戏ID
}