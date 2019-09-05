package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/5 11:12
 * @Description：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Details {

    private Integer id;             //唯一标识ID
    private String name;            //游戏介绍
    private String feature;         //游戏特色
    private String imageConfig;     //DIY推荐配置
    private String image;           //游戏图片

}