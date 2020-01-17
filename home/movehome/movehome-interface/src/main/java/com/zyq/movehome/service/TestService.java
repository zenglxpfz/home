package com.zyq.movehome.service;

import com.zyq.movehome.dto.TestGetDTO;

import java.util.List;

/**
 * @author: ZengYunQi
 * @time: 2019/12/31 - 15:48
 */
public interface TestService {
    List<TestGetDTO> get();

    TestGetDTO selectone(Integer deptId);

}
