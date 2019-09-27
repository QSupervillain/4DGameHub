package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Order implements Serializable {
    private static final long serialVersionUID = -4532241936033527116L;
    private int pay_id;             //唯一标识
    private String order_no;           //订单号
    private int pay_platform;       //支付平台:1-支付宝、2-微信
    private String pay_number;         //支付宝支付的流水号
    private Date pay_createtime;    //创建时间
    private double pay_prince;      //支付金额
}
