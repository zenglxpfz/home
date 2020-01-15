package com.zyq.movehome.serviceImpl;


import com.zyq.movehome.dto.TestGetDTO;

import com.zyq.movehome.mapper.TestMapper;
import com.zyq.movehome.service.TestService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2019/12/30 - 17:52
 */
@Service
public class TestServiceImpl implements TestService
{

   // org.slf4j.Logger logger;



    @Resource
    private TestMapper testMapper;


    @Override
    public List<TestGetDTO> get() {
        return testMapper.get();

    }

    @Logger
    @Override
    public TestGetDTO selectone(Integer deptId){

       // logger.info("执行成功");
        return testMapper.selectone(deptId);
    }



}
