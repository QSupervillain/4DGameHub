package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (GmNewsType)实体类
 *
 * @author makejava
 * @since 2019-09-07 16:11:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GmNewsType implements Serializable {
    private static final long serialVersionUID = 297354021901624505L;
    //新闻类型id
    private Integer type_id;
    //新闻类型名称
    private String type_name;
}