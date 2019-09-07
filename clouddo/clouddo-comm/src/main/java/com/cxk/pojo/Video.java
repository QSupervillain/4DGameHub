package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data//get set  toString 合集
@AllArgsConstructor//为类添加包含所有成员变量的带参构造函数
@NoArgsConstructor//为类添加无参构造函数
@Builder //为类中添加一个内部工厂类，通过工厂类可以链式调用构建主类对Pagination象。
public class Video {
    private int video_id;
    private String video_title;//标题
    private String video_image;//图片
    private String video_content;//类容
    private String video_src;//视屏路径
    private Date video_date;//发布时间
    private int video_type;//视屏类型
}
