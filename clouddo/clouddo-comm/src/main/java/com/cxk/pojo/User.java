package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/15 21:33
 * @Description：用户表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = -4532241936033527116L;
    private Integer user_id;                       //唯一标识ID
    private String user_name;                        //用户名
    private String user_pwd;                       //用户密码
    private Integer user_role;                     //角色0普通、1小编、-1管理员
    private String user_phone;                     //手机号
    private String user_email;                     //邮箱
    private String user_image;                     //头像
    private String user_question;                  //找回密码问题
    private String user_answer;                    //找回密码答案

}