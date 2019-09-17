package com.cxk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data//get set  toString 合集
@AllArgsConstructor//为类添加包含所有成员变量的带参构造函数
@NoArgsConstructor//为类添加无参构造函数
@Builder //为类中添加一个内部工厂类，通过工厂类可以链式调用构建主类对Pagination象。
public class Video implements Serializable {
    private int video_id;
    private String video_title;//标题
    private String video_image;//图片
    private String video_content;//类容
    private String video_src;//视屏路径
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date video_date;//发布时间
    private int video_type;//视屏类型
/*
    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_image() {
        return video_image;
    }

    public void setVideo_image(String video_image) {
        this.video_image = video_image;
    }

    public String getVideo_content() {
        return video_content;
    }

    public void setVideo_content(String video_content) {
        this.video_content = video_content;
    }

    public String getVideo_src() {
        return video_src;
    }

    public void setVideo_src(String video_src) {
        this.video_src = video_src;
    }
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    public Date getVideo_date() {
        return video_date;
    }

    public void setVideo_date(Date video_date) {
        this.video_date = video_date;
    }

    public int getVideo_type() {
        return video_type;
    }

    public void setVideo_type(int video_type) {
        this.video_type = video_type;
    }

    @Override
    public String toString() {
        return "Video{" +
                "video_id=" + video_id +
                ", video_title='" + video_title + '\'' +
                ", video_image='" + video_image + '\'' +
                ", video_content='" + video_content + '\'' +
                ", video_src='" + video_src + '\'' +
                ", video_date=" + video_date +
                ", video_type=" + video_type +
                '}';
    }*/
}
