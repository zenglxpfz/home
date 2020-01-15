package com.zyq.movehome.controller;

import com.zyq.movehome.dto.TestGetDTO;
import com.zyq.movehome.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    RedisTemplate redisTemplate;



//    @RequestMapping(value = "/test")
//    public List<TestGetDTO> test(){
//
//        List<TestGetDTO> list = testService.get();
//        System.out.println(list);
//        return list;
//    }

    @RequestMapping(value = "/g")
    public String  select(ServletRequest request){

        TestGetDTO  a = testService.selectone(1);
        redisTemplate.opsForList().leftPush("user1",a);

        request.setAttribute("user",a);
        System.out.println(redisTemplate.opsForList().leftPop("user1"));
        return "test";
    }

    @RequestMapping("/login")
    public String  selecta(Model model){

        //TestGetDTO  a = testService.selectone(1);
        model.addAttribute("user","he");
        //System.out.println();
        return "test";
    }

}
