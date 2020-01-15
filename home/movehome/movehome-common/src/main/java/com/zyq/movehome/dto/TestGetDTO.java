package com.zyq.movehome.dto;

import lombok.Data;
import sun.plugin2.message.Serializer;

import java.io.Serializable;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2019/12/31 - 15:43
 */
@Data
public class TestGetDTO implements Serializable {

    private Integer deptId;
    private String deptName;
}
