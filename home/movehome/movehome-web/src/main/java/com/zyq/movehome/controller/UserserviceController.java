package com.zyq.movehome.controller;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.SouDTO;
import com.zyq.movehome.dto.UserDTO;
import com.zyq.movehome.dto.UserserviceDTO;
import com.zyq.movehome.dto.UserserviceNewDTO;
import com.zyq.movehome.service.UserserviceService;
import com.zyq.movehome.util.AppException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:49
 */
@RestController
@RequestMapping("/userservice")
@Api(value = "注册提供服务的用户控制器")
public class UserserviceController {
    @Autowired
    UserserviceService userserviceService;
    @ApiOperation(value = "用户添加接口",notes = "注册用户")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public MsgResult<Boolean> add(UserserviceNewDTO userserviceNewDTO, MultipartFile file, HttpServletRequest req){
        try {
            if(file!=null) {
                File f = new File("");//创建新的空文件
                //f.getAbsolutePath()项目路径到项目名
                String realpath = f.getAbsolutePath() + "/home/movehome/movehome-web/src/main/resources/static/images/";

                //设置文件名字
                String newname = file.getOriginalFilename();
                //创建新文件
                File f2 = new File(realpath + newname);

                file.transferTo(f2);
                //文件路径
                String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/images/" + newname;

            userserviceNewDTO.setPicture(filePath);
        }
            return userserviceService.addUserservice(userserviceNewDTO);

        } catch (Exception e) {
            throw new AppException(HomeEnum.SystemCode.System_ERROR.code);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户接口",notes = "修改用户信息")
    public MsgResult<Boolean> update(@RequestBody UserserviceDTO userserviceDTO,MultipartFile file, HttpServletRequest req){

        try {
            if(file!=null) {
                File f = new File("");//创建新的空文件
                //f.getAbsolutePath()项目路径到项目名
                String realpath = f.getAbsolutePath() + "/src/main/resources/static/images/";

                //设置文件名字
                String newname = file.getOriginalFilename();
                //创建新文件
                File f2 = new File(realpath + newname);

                file.transferTo(f2);
                //文件路径
                String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/images/" + newname;

                userserviceDTO.setPicture(filePath);
            }
            return userserviceService.update(userserviceDTO);
        } catch (IOException e) {
            throw new AppException(HomeEnum.SystemCode.System_ERROR.code);
        }

    }

    @RequestMapping(value = "/selectlist",method = RequestMethod.GET)
    @ApiOperation(value = "分页查询用户接口",notes = "分页查询用户信息，10条一页，拿五页")
    public MsgResult<PageInfo<List<UserserviceDTO>>> select(@PathParam("pn") Integer pn){

        return userserviceService.selectUserserviceList(pn);
    }


    @RequestMapping(value = "/delect",method = RequestMethod.POST)
    @ApiOperation(value = "删除查询用户接口",notes = "分页查询用户信息，10条一页，拿五页")
    public MsgResult<Boolean> select(@RequestBody UserserviceDTO userserviceDTO){

        return userserviceService.delect(userserviceDTO);
    }

    @RequestMapping(value = "/selectOne",method = RequestMethod.GET)
    @ApiOperation(value = "查询用户接口",notes = "")
    public MsgResult<UserserviceDTO> selectOne(@PathParam("uid")Integer uid){

        return userserviceService.selectOne(uid);
    }

    @RequestMapping(value = "/selectOnebyname",method = RequestMethod.GET)
    @ApiOperation(value = "查询用户接口",notes = "")
    public MsgResult<UserserviceDTO> selectOnebyname(@PathParam("uname")String uname){
        UserserviceDTO userserviceDTO = new UserserviceDTO();
        userserviceDTO.setUname(uname);
        List<UserserviceDTO> list = userserviceService.selectListUserservice(userserviceDTO);
        UserserviceDTO u = list.get(0);
        return MsgResult.success(u);
    }

    @RequestMapping(value = "/selectNullCode",method = RequestMethod.GET)
    @ApiOperation(value = "查询用户",notes = "")
    public MsgResult<List<UserserviceDTO>> selectNullCode(){

        return userserviceService.selectNullcode();
    }

    @RequestMapping(value = "/selectbykey",method = RequestMethod.POST)
    @ApiOperation(value = "模糊查询用户",notes = "")
    public MsgResult<List<UserserviceDTO>> selectNullCode(@RequestBody SouDTO souDTO){

        return userserviceService.selectbykey(souDTO);
    }




}
