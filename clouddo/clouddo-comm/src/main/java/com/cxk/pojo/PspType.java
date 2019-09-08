package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/5 19:24
 * @Description：攻略类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PspType {
    private static final long serialVersionUID = 2932723630990138417L;

    private Integer psptype_id;

    private String psptype_name;
}