package com.zyq.movehome.controller;

import com.zyq.movehome.dto.TestGetDTO;
import com.zyq.movehome.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2019/12/30 - 17:35
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;


    @ResponseBody
    @RequestMapping(value = "/test")
    public List<TestGetDTO> test(){

        List<TestGetDTO> list = testService.get();

        return list;
    }


}
