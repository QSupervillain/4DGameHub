package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/11 9:59
 * @Description：游戏名称
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PspName implements Serializable {
    private static final long serialVersionUID = 2932723630990138417L;
    private int pspname_id;
    private String pspname_name;
}