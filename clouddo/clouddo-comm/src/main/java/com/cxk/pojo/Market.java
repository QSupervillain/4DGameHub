package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/20 10:41
 * @Description：商城
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Market implements Serializable {
    private static final long serialVersionUID = -4532241936033527116L;
    private int game_id;
    private int type_id;            //类型
    private int account_id;         //账号
    private String game_title;      //标题
    private String game_describe;   //描述
    private int game_QQ;            //联系方式
    private String game_image;      //图片
    private BigDecimal game_money;  //价格
    private Date game_time;         //创建时间
    private int game_status;        //状态-1表示已卖出0等待卖出
    private String game_region;     //大区服务器
}