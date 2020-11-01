package com.zyq.movehome.controller;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.service.ResoucesService;
import com.zyq.movehome.util.AppException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.File;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:47
 */
@Controller
@Api(value = "资源管理接口")
public class ResoucesController {
    @Autowired
    ResoucesService resoucesService;

    @ResponseBody
    @ApiOperation(value = "团队添加资源接口",notes = "新增资源信息")
    @RequestMapping(value = "/resouces/create",method = RequestMethod.POST)
    public MsgResult<Boolean> add(@RequestBody ResoucesNewDTO resoucesNewDTO, MultipartFile file, HttpSession session, HttpServletRequest req) {

        try {//创建一个新的文件在这里
            if (file != null) {
                File f = new File("");
                //设置真实路径保存文件
                String newname = file.getOriginalFilename();
                String realpath = f.getAbsolutePath() + "/src/main/resources/static/images/";

                // String realPath = f.getAbsolutePath() + "/home/movehome/movehome-web/src/java/resources/"
                File f2 = new File(realpath + newname);
                file.transferTo(f2);
                String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/images/" + newname;

                resoucesNewDTO.setPicture(filePath);
            }

          //  TeamDTO team = (TeamDTO) session.getAttribute("team");
          //  resoucesNewDTO.setTid(team.getTid());
           resoucesNewDTO.setStatus("0");
            return resoucesService.addResouse(resoucesNewDTO);


        } catch (Exception e) {
            throw new AppException(HomeEnum.SystemCode.ERROR_CREATETEAM.message);

        }
    }

    @ResponseBody
    @ApiOperation(value = "分页查询所有资源信息列表接口",notes = "查询资源列表信息接口")
    @RequestMapping(value = "/resouces/page",method = RequestMethod.GET)
    public MsgResult<PageInfo<List<ResoucesDTO>>> selectresouceslist(@PathParam("pn") Integer pn){

        Integer tid = null;
        return resoucesService.selectResouceslist(pn,tid);
    }

    @ResponseBody
    @ApiOperation(value = "分页查询个人团队所有资源信息列表接口",notes = "查询资源列表信息接口")
    @RequestMapping(value = "/resouces/mypage",method = RequestMethod.GET)
    public MsgResult<PageInfo<List<ResoucesDTO>>> selectMyresouceslist(@PathParam("pn") Integer pn,HttpSession session){

        TeamDTO team = (TeamDTO) session.getAttribute("team");
        Integer tid = team.getTid();
        session.setMaxInactiveInterval(80*60);
        return resoucesService.selectResouceslist(pn,tid);
    }
    @ResponseBody
    @ApiOperation(value = "删除所有资源信息列表接口",notes = "查询资源列表信息接口")
    @RequestMapping(value = "/resouces/del",method = RequestMethod.POST)
    public MsgResult<Boolean> delect(@RequestBody ResoucesDTO resoucesDTO){

        return resoucesService.delect(resoucesDTO);
    }

    @ResponseBody
    @ApiOperation(value = "分页查询个人团队所有资源信息列表接口",notes = "查询资源列表信息接口")
    @RequestMapping(value = "/resouces/edit",method = RequestMethod.POST)
    public MsgResult<Boolean> selectedit(@RequestBody ResoucesDTO resoucesDTO){

        return resoucesService.update(resoucesDTO);
    }

}
