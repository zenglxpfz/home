package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.OrderDTO;
import com.zyq.movehome.dto.OrderNewDTO;
import com.zyq.movehome.dto.TorderTeamResult;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(OrderNewDTO record);

    int insertSelective(OrderNewDTO record);

    OrderDTO selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(OrderDTO record);

    int updateByPrimaryKey(OrderDTO record);

    //查看订单详情
    List<OrderDTO> selectAll(OrderDTO orderDTO);

    OrderDTO selectOne(Integer oid);

    //查询出订单最多的团队名
    List<TorderTeamResult> selectTopOrder(OrderDTO orderDTO);

    Integer selectcount(String tname);

    List<OrderDTO> page();
}