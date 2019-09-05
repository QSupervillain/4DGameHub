package com.cxk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/4 23:29
 * @Description：游戏类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GameType implements Serializable {

    private static final long serialVersionUID = 2932723630990138417L;
    private Integer gameType_id;
    private String gameType_name;

}
