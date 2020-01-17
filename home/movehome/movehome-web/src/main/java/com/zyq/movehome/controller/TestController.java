package com.zyq.movehome.controller;

import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.TestGetDTO;
import com.zyq.movehome.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2019/12/30 - 17:35
 */
@RestController
@Api(description = "测试赛所所")
@RequestMapping("/test")
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

    @ApiOperation(value = "测试接口", notes = "对项目进行测试")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="id",value = "用户id",required = true,dataType = "Integer"),
//            @ApiImplicitParam(name = "name",value = "用户名",required = true,dataType = "String")
//    })
    @RequestMapping(value = "/g", method = RequestMethod.GET)
    public MsgResult<Boolean> select(ServletRequest request) {

        TestGetDTO a = testService.selectone(1);
        redisTemplate.opsForList().leftPush("user1", a);

        request.setAttribute("user", a);
        System.out.println(redisTemplate.opsForList().leftPop("user1"));
        return MsgResult.success(true).add("a", "b").add("c", "d");
    }

    @ApiOperation(value = "登录测试", notes = "对登录进行测试")
    @GetMapping("/login")
    public String selecta(Model model, TestGetDTO dto) {

        //TestGetDTO  a = testService.selectone(1);
        model.addAttribute("user", "he");
        //System.out.println();
        return "test";
    }

}
