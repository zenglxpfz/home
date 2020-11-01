package com.zyq.movehome.service;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.OrderDTO;
import com.zyq.movehome.dto.OrderNewDTO;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
public interface OrderService {
    MsgResult<Boolean> addorder(OrderNewDTO orderNewDTO);

    MsgResult<PageInfo<List<OrderDTO>>> selectAll(OrderDTO orderDTO);
    //查询订单详情
    MsgResult<OrderDTO> selectOne(Integer oid);

    //修改订单状态
    MsgResult<Boolean> editStatusByOid(OrderDTO orderDTO);

    MsgResult<PageInfo<List<OrderDTO>>> getall(Integer pn);



}
