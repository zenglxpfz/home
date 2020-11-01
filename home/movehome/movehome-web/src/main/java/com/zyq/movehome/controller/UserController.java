package com.zyq.movehome.controller;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.UserDTO;
import com.zyq.movehome.dto.UserNewDTO;
import com.zyq.movehome.dto.UserserviceDTO;
import com.zyq.movehome.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunHints;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:49
 */
@RestController
@Api(description = "用户user控制器")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户接口",notes = "注册用户，ajax传实体类过来")
    public MsgResult<Boolean> addUser(@RequestBody UserNewDTO userNewDTO){

       return userService.addUser(userNewDTO);
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户接口",notes = "修改用户信息")
    public MsgResult<Boolean> update(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return userService.update(userDTO);
    }
    @RequestMapping(value = "/selectlist",method = RequestMethod.GET)
    @ApiOperation(value = "分页查询用户接口",notes = "分页查询用户信息，10条一页，拿五页")
    public MsgResult<PageInfo<List<UserDTO>>> select(@PathParam("pn") Integer pn){

        return userService.selectUserList(pn);
    }
    @RequestMapping(value = "/selectuser",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户接口",notes = "页")
    public MsgResult<UserDTO> select(@RequestBody UserDTO userDTO){

        return userService.selectUserByUid(userDTO);
    }
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ApiOperation(value = "删除查询用户接口",notes = "")
    public MsgResult<Boolean> delect(@RequestBody UserDTO userDTO){

        return userService.delect(userDTO);
    }

}
