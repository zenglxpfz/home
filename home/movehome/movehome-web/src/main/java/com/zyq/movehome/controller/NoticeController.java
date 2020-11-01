package com.zyq.movehome.controller;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.service.AppraisalService;
import com.zyq.movehome.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
@RestController
@Api(value = "服务内容控制器")
public class NoticeController {

    @Autowired
    NoticeService noticeService;
    @Autowired
    AppraisalService appraisalService;

    @ApiOperation(value = "添加内容接口",notes = "添加内容接口")
    @RequestMapping(value = "/notice/add",method = RequestMethod.POST)
    public MsgResult<Boolean> add(@RequestBody NoticeDTO noticeDTO, HttpSession session){

       UserDTO team = (UserDTO) session.getAttribute("user");
       // contentNewDTO.setTid(team.getTid());
        session.setMaxInactiveInterval(80*60);
        System.out.println(team);
        return noticeService.addNotice(noticeDTO);
    }

    @ApiOperation(value = "查询自己团队所有服务内容接口",notes = "查询服务内容接口")
    @RequestMapping(value = "/notice/selectlist",method = RequestMethod.GET)
    public MsgResult<PageInfo<List<NoticeDTO>>> selectList(@PathParam("pn") Integer pn){


        return noticeService.selectNoticeList(pn);
    }

    @ApiOperation(value = "查询自己团队所有服务内容接口",notes = "查询服务内容接口")
    @RequestMapping(value = "/notice/delect",method = RequestMethod.GET)
    public MsgResult<Boolean> decet(@PathParam("bid") Integer bid){

        return noticeService.delect(bid);
    }

    @ApiOperation(value = "查询详细通知接口",notes = "查询详细通知")
    @RequestMapping(value = "/notice/selectbyid",method = RequestMethod.GET)
    public MsgResult<NoticeDTO> selct(@PathParam("bid") Integer bid){
        return noticeService.selectByid(bid);
    }


    @RequestMapping(value = "/notice/del",method = RequestMethod.POST)
    @ApiOperation(value = "删除规则接口",notes = "")
    public MsgResult<Boolean> delect1(@RequestBody NoticeDTO contentDTO){

        return noticeService.delect1(contentDTO);
    }

    @RequestMapping(value = "/notice/edit",method = RequestMethod.POST)
    @ApiOperation(value = "编辑规则接口",notes = "")
    public MsgResult<Boolean> edit(@RequestBody NoticeDTO contentDTO){

        return noticeService.edit(contentDTO);
    }


    @RequestMapping(value = "/notice/addpl",method = RequestMethod.POST)
    @ApiOperation(value = "添加评论接口",notes = "")
    public MsgResult<Boolean> addpl(@RequestBody AppraisalDTO dto){

        return noticeService.addpl(dto);
    }

    @RequestMapping(value = "/notice/getpinlun",method = RequestMethod.GET)
    @ApiOperation(value = "添加评论接口",notes = "")
    public MsgResult<List<AppraisalDTO>> getpl(@PathParam("zid") Integer zid){

        return appraisalService.selectByZid(zid);
    }

    @RequestMapping(value = "/notice/selectbykey",method = RequestMethod.POST)
    @ApiOperation(value = "接口",notes = "")
    public MsgResult<PageInfo<List<NoticeDTO>>>shou(@RequestBody SouDTO souDTO){

        return noticeService.selectbykey(souDTO);
    }

}
