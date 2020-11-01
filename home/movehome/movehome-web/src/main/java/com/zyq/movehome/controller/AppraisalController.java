package com.zyq.movehome.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnums;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.HuifuplMapper;
import com.zyq.movehome.mapper.OrderMapper;
import com.zyq.movehome.mapper.TeamMapper;
import com.zyq.movehome.service.AppraisalService;
import com.zyq.movehome.service.ContentService;
import com.zyq.movehome.service.HuifuplService;
import com.zyq.movehome.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:44
 */
@Controller
//@RequestMapping("/pinglun")
@Api(value = "评论内容控制器")
public class AppraisalController {

    @Autowired
    AppraisalService appraisalService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    ContentService contentService;

    @Autowired
    HuifuplService huifuplService;

    @ResponseBody
    @ApiOperation(value = "添加评论接口",notes = "添加评论接口")
    @RequestMapping(value = "/pinglun/add",method = RequestMethod.POST)
    public MsgResult<Boolean> add(@RequestBody AppraisalNewDTO appraisalNewDTO, HttpSession session){
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        session.setMaxInactiveInterval(80*60);
        //判断类型如果是1就是评论
        if(appraisalNewDTO.getType().equals(HomeEnums.pingluntype.PINGLUN.getCode())){
            TeamDTO teamDTO1 = new TeamDTO();
            teamDTO1.setTname(appraisalNewDTO.getTname());
            TeamDTO teamDTO = teamMapper.selectTeam(teamDTO1);
            appraisalNewDTO.setCreatetime(new Date());
            appraisalNewDTO.setTid(teamDTO.getTid());
            appraisalNewDTO.setUid(userDTO.getUid());
            appraisalNewDTO.setType("1");
            return appraisalService.addAppraisal(appraisalNewDTO);
        }
        //如果是类型2就是回复评论

          //  TeamDTO teamDTO1 = new TeamDTO();
          //  teamDTO1.setTname(appraisalNewDTO.getTname());
          //  TeamDTO teamDTO = teamMapper.selectTeam(teamDTO1);
            HuifuplDTO huifuplDTO = new HuifuplDTO();
            //回复的评论id为父id
            huifuplDTO.setFid(appraisalNewDTO.getFid());
            huifuplDTO.setCreatetime(new Date());
            huifuplDTO.setContent(appraisalNewDTO.getContent());
            huifuplDTO.setUseredname(appraisalNewDTO.getUseredname());
            huifuplDTO.setUsername(appraisalNewDTO.getUsername());
            huifuplDTO.setType("2");
            //huifu人为

//
            return huifuplService.insert(huifuplDTO);

        //保存数据到不同的表

       //

       //拿到订单信息
      //  OrderDTO orderDTO = (OrderDTO) session.getAttribute("order");
//        TeamDTO teamDTO1 = new TeamDTO();
//        teamDTO1.setTname(appraisalNewDTO.getTname());
//        TeamDTO teamDTO = teamMapper.selectTeam(teamDTO1);
//           appraisalNewDTO.setCreatetime(new Date());
//          appraisalNewDTO.setTid(teamDTO.getTid());
//          appraisalNewDTO.setUid(userDTO.getUid());
//           return appraisalService.addAppraisal(appraisalNewDTO);


    }

    @ApiOperation(value = "查询自己团队所有服务内容接口",notes = "查询服务内容接口")
    @RequestMapping(value = "/selectlist",method = RequestMethod.GET)
    public MsgResult<List<ContentDTO>> selectList(HttpSession session){

        TeamDTO team = (TeamDTO) session.getAttribute("team");
        session.setMaxInactiveInterval(80*60);

        return contentService.selectBytid(team.getTid());
    }

    @ApiOperation(value = "点击评论时",notes = "查询订单的内容接口")
    @RequestMapping(value = "/pinglun/selectorder",method = RequestMethod.GET)
    public String  selectallpinglun(@PathParam("oid") Integer oid,HttpSession session){

        OrderDTO orderDTO = orderMapper.selectByPrimaryKey(oid);
        session.setAttribute("order",orderDTO);
        session.setMaxInactiveInterval(80*60);
        return "/pinglun/add.html";
    }

    @ResponseBody
    @ApiOperation(value = "点击订单时",notes = "查询订单的详情和加载评论")
    @RequestMapping(value = "/pinglun/selectall",method = RequestMethod.GET)
    public MsgResult<List<AppraisalDTO>>  selectone(@PathParam("oid")Integer oid,HttpSession session){



        return appraisalService.selectByoid(oid);
    }

    @ResponseBody
    @ApiOperation(value = "分页评论",notes = "查询订单的内容接口")
    @RequestMapping(value = "/pinglun/page",method = RequestMethod.GET)
    public MsgResult<PageInfo<List<AppraisalDTO>>>  page(@PathParam("pn") Integer pn){

        return  appraisalService.selectAll(pn);
    }

    @RequestMapping(value = "/pinglun/delect",method = RequestMethod.POST)
    @ApiOperation(value = "删除查询用户接口",notes = "分页查询用户信息，10条一页，拿五页")
    public MsgResult<Boolean> select(@RequestBody AppraisalDTO appraisalDTO){

        return appraisalService.delect(appraisalDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/pinglun/del",method = RequestMethod.GET)
    @ApiOperation(value = "删除评论",notes = "")
    public MsgResult<Boolean> del(@PathParam("aid")Integer aid){

        return appraisalService.delete(aid);
    }


    @ResponseBody
    @RequestMapping(value = "/huifupl/del",method = RequestMethod.GET)
    @ApiOperation(value = "删除评论",notes = "")
    public MsgResult<Boolean> delhuifu(@PathParam("aid")Integer aid){

        return huifuplService.delect(aid);
    }
}
