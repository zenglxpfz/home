package com.zyq.movehome.controller;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.HomeEnums;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.OrderMapper;
import com.zyq.movehome.service.ContentService;
import com.zyq.movehome.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
@Controller
@Api(value = "订单控制器")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ContentService contentService;

    @Autowired
    OrderMapper orderMapper;

    @ResponseBody
    @ApiOperation(value = "添加订单内容接口", notes = "添加订单内容接口")
    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public MsgResult<Boolean> add(@RequestBody OrderNewDTO orderNewDTO, HttpSession session) {

        int id = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
//        Date d = new Date();sdf.format(d)
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderNewDTO.setCreatetime(new Date());
        orderNewDTO.setStatus("0");
        orderNewDTO.setOid(id);
        return orderService.addorder(orderNewDTO);
    }

    @ResponseBody
    @ApiOperation(value = "查询自己团队所有订单和用户自己的订单接口", notes = "查询订单接口")
    @RequestMapping(value = "/order/selectmy", method = RequestMethod.POST)
    public MsgResult<PageInfo<List<OrderDTO>>> selectList(@RequestBody OrderDTO orderDTO, HttpSession session) {
//        if(StringUtils.isEmpty(orderDTO.getUname())&&StringUtils.isEmpty(orderDTO.getTname())){
//            return MsgResult.fail(HomeEnum.SystemCode.RELOGIN.code,HomeEnum.SystemCode.RELOGIN.message);
//        }

        if (StringUtils.isEmpty(orderDTO.getUname())) {
            return orderService.selectAll(orderDTO);
        } else {
            orderDTO.setTname(null);
            return orderService.selectAll(orderDTO);
        }
    }

    @ResponseBody
    @ApiOperation(value = "查询自己订单接口", notes = "查询订单接口")
    @RequestMapping(value = "/order/selectAlllist", method = RequestMethod.GET)
    public MsgResult<PageInfo<List<OrderDTO>>> selectList(@PathParam("pn")Integer pn, HttpSession session) {

        //获取团队用户的信息
        UserserviceDTO userserviceDTO = (UserserviceDTO) session.getAttribute("userservice");
        TeamDTO team = (TeamDTO) session.getAttribute("team");
        //获取用户的信息；
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        session.setMaxInactiveInterval(80*60);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setPn(pn);
        if (team == null) {
            orderDTO.setUname(userDTO.getUname());
            return orderService.selectAll(orderDTO);
        }
        //查询用户自己的订单
        orderDTO.setUname(userserviceDTO.getUname());
        orderDTO.setTname(team.getTname());
        return orderService.selectAll(orderDTO);
    }

    @ApiOperation(value = "点击订单带两个参数到订单页面", notes = "")
    @RequestMapping(value = "/order/getorder", method = RequestMethod.POST)
    public String selectone(@RequestBody OrderDTO orderDTO, HttpSession session) {
        session.setAttribute("order",orderDTO);
        session.setMaxInactiveInterval(80*60);
        return "user/orderpinglun.html";
    }

    //点击完成订单时，修改订单状态
    @ResponseBody
    @ApiOperation(value = "修改订单状态", notes = "修改订单状态,根据前端传递的字段和id去修改状态")
    @RequestMapping(value = "/order/edit", method = RequestMethod.POST)
    public MsgResult<Boolean> edit(@RequestBody OrderDTO orderDTO) {
        return orderService.editStatusByOid(orderDTO);
    }

    //点击完成订单时，修改订单状态
    @ResponseBody
    @ApiOperation(value = "分页查询所有订单", notes = "")
    @RequestMapping(value = "/order/selectall", method = RequestMethod.GET)
    public MsgResult<PageInfo<List<OrderDTO>>> get(@PathParam("pn")Integer pn) {

        return orderService.getall(pn);
    }


    @ResponseBody
    @ApiOperation(value = "查询订单详情", notes = "")
    @RequestMapping(value = "/order/getone", method = RequestMethod.GET)
    public MsgResult<List<OrderDTO>> select(HttpSession session) {
        OrderDTO orderDTO = new OrderDTO();
        OrderDTO order = (OrderDTO) session.getAttribute("order");
        orderDTO.setOid(order.getOid());
        List<OrderDTO> orderDTOS = orderMapper.selectAll(orderDTO);
        session.setMaxInactiveInterval(80*60);
        return MsgResult.success(orderDTOS);
    }
}
