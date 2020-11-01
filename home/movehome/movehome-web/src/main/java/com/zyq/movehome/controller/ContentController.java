package com.zyq.movehome.controller;

import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.ContentDTO;
import com.zyq.movehome.dto.ContentNewDTO;
import com.zyq.movehome.dto.MessageDTO;
import com.zyq.movehome.dto.TeamDTO;
import com.zyq.movehome.service.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.text.BadLocationException;
import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
@RestController
@RequestMapping("/content")
@Api(value = "服务内容控制器")
public class ContentController {

    @Autowired
    ContentService contentService;

    @ApiOperation(value = "添加服务内容接口",notes = "添加服务内容接口")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public MsgResult<Boolean> add(@RequestBody ContentNewDTO contentNewDTO, HttpSession session){

       //TeamDTO team = (TeamDTO) session.getAttribute("team");
       // contentNewDTO.setTid(team.getTid());
        contentNewDTO.setCreatetime(new Date());
        return contentService.addContent(contentNewDTO);
    }

    @ApiOperation(value = "查询自己团队所有服务内容接口",notes = "查询服务内容接口")
    @RequestMapping(value = "/selectlist",method = RequestMethod.GET)
    public MsgResult<List<ContentDTO>> selectList(HttpSession session){

        TeamDTO team = (TeamDTO) session.getAttribute("team");
        session.setMaxInactiveInterval(80*60);
        return contentService.selectBytid(team.getTid());
    }

    @ApiOperation(value = "查询自己团队所有服务内容接口",notes = "查询服务内容接口")
    @RequestMapping(value = "/selectone/{cid}",method = RequestMethod.GET)
    public MsgResult<ContentDTO> selectone(@PathVariable("cid")Integer cid){

        return contentService.selectByid(cid);
    }

    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ApiOperation(value = "删除规则接口",notes = "")
    public MsgResult<Boolean> delect1(@RequestBody ContentDTO contentDTO){

        return contentService.delect(contentDTO);
    }
    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "编辑规则接口",notes = "")
    public MsgResult<Boolean> edit(@RequestBody ContentDTO contentDTO){

        return contentService.edit(contentDTO);
    }

}
