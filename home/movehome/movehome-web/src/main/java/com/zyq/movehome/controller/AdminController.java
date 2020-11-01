package com.zyq.movehome.controller;

import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.UserserviceDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:43
 */
@Controller
public class AdminController {

    //下单跳转
    @RequestMapping(value = "/admin/order" ,method = RequestMethod.GET)
    public String order(){

        return "admin/order.html";
    }
    //下单跳转
    @RequestMapping(value = "/admin/team" ,method = RequestMethod.GET)
    public String team(){

        return "admin/team.html";
    }
    //下单跳转
    @RequestMapping(value = "/admin/user" ,method = RequestMethod.GET)
    public String user(){

        return "admin/user.html";
    }
    //下单跳转
    @RequestMapping(value = "/admin/userservice" ,method = RequestMethod.GET)
    public String userservice(){

        return "admin/userservice.html";
    }
    //下单跳转
    @RequestMapping(value = "/admin/comment" ,method = RequestMethod.GET)
    public String comment(){

        return "admin/comment.html";
    }

    //liuyan跳转
    @RequestMapping(value = "/admin/message" ,method = RequestMethod.GET)
    public String message(){

        return "admin/message.html";
    }
    //liuyan跳转
    @RequestMapping(value = "/admin/main" ,method = RequestMethod.GET)
    public String main(){

        return "admin/main.html";
    }

    //liuyan跳转
    @RequestMapping(value = "/admin/resource" ,method = RequestMethod.GET)
    public String resource(){

        return "admin/resource.html";
    }


}
