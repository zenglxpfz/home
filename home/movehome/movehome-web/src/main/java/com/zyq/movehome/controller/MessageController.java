package com.zyq.movehome.controller;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.MessageDTO;
import com.zyq.movehome.dto.MhuifuDTO;
import com.zyq.movehome.dto.UserserviceDTO;
import com.zyq.movehome.service.MessageService;
import com.zyq.movehome.service.MhuifuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
@Controller
public class MessageController {

    @Autowired
    MessageService messageService;
    @Autowired
    MhuifuService mhuifuService;


    @ResponseBody
    @RequestMapping(value = "/mes/add",method = RequestMethod.POST)
    public MsgResult<List<MessageDTO>> add(@RequestBody MessageDTO messageDTO){

        return messageService.add(messageDTO);
    }

    //添加留言回复
    @ResponseBody
    @RequestMapping(value = "/mhuifu/add",method = RequestMethod.POST)
    public MsgResult<Boolean> addhuifu(@RequestBody MhuifuDTO messageDTO){

        return mhuifuService.insert(messageDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/mes/selectour",method = RequestMethod.POST)
    public MsgResult<List<MessageDTO>> select(@RequestBody MessageDTO messageDTO){

        return messageService.selectBytiduid(messageDTO);
    }

    //uid ,tid,mid
    @ResponseBody
    @RequestMapping(value = "/mes/delect",method = RequestMethod.GET)
    public MsgResult<List<MessageDTO>> delect(@PathParam("mid")Integer mid){

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMid(mid);
        return messageService.delect(messageDTO);
    }

    //uid ,tid,mid
    @ResponseBody
    @RequestMapping(value = "/mhuifu/del",method = RequestMethod.GET)
    public MsgResult<Boolean> delecthuifu(@PathParam("mid")Integer mid){

        return mhuifuService.delect(mid);
    }

    @ResponseBody
    @RequestMapping(value = "/mes/selectmy",method = RequestMethod.POST)
    public MsgResult<List<MessageDTO>> selectmy(@RequestBody MessageDTO messageDTO){

        return messageService.selectmy(messageDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/mes/page",method = RequestMethod.GET)
    public MsgResult<PageInfo<List<MessageDTO>>> pgae(@PathParam("pn")Integer pn){

        return messageService.page(pn);
    }
    @ResponseBody
    @RequestMapping(value = "/mes/del",method = RequestMethod.POST)
    @ApiOperation(value = "删除查询用户接口",notes = "分页查询用户信息，10条一页，拿五页")
    public MsgResult<Boolean> delect1(@RequestBody MessageDTO messageDTO){

        return messageService.delects(messageDTO);
    }
}
