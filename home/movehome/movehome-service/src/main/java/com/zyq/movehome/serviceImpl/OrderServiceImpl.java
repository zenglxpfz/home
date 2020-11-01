package com.zyq.movehome.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.AppraisalMapper;
import com.zyq.movehome.mapper.HuifuplMapper;
import com.zyq.movehome.mapper.OrderMapper;
import com.zyq.movehome.mapper.TeamMapper;
import com.zyq.movehome.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.mail.internet.NewsAddress;
import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    TeamMapper teamMapper;

    @Autowired
    HuifuplMapper huifuplMapper;

    @Autowired
    AppraisalMapper appraisalMapper;

    @Override
    public MsgResult<Boolean> addorder(OrderNewDTO orderNewDTO)
    {
        orderMapper.insertSelective(orderNewDTO);
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTname(orderNewDTO.getTname());
        TeamDTO teamDTO1 = teamMapper.selectTeam(teamDTO);
        StringBuffer s = new StringBuffer();
        //如果收消息的人是用户，
               s.append(orderNewDTO.getUname()+"用户给您团队下了一条订单，请您去处理！！");
//         s.append(huifuDTO.getUsername()+"用户回复了您一条信息，赶紧去查看！！");
//        EmailUtil  emitUtil = new EmailUtil();
//        emitUtil.sendEamilCode(teamDTO1.getTemail(),"订单通知",s.toString());

        return MsgResult.success(true);
    }

    @Override
    public MsgResult<PageInfo<List<OrderDTO>>> selectAll(OrderDTO orderDTO) {
        PageHelper.startPage(orderDTO.getPn(),5);
        List<OrderDTO> list = orderMapper.selectAll(orderDTO);
        PageInfo pageInfo = new PageInfo(list,5);

        return MsgResult.success(pageInfo).add("orderlist",pageInfo);

    }

    @Override
    public MsgResult<OrderDTO> selectOne(Integer oid) {
       OrderDTO dto = orderMapper.selectOne(oid);
       Integer i = appraisalMapper.selectcountByoid(oid);
       dto.setCountpl(i);
         //  TeamDTO teamDTO = teamMapper.selectByPrimaryKey(dto.get)
        return MsgResult.success(dto);
    }

    @Override
    public MsgResult<Boolean> editStatusByOid(OrderDTO orderDTO) {

      if(orderDTO.getType().equals("2"))
      { orderDTO.setStatus("2");
          orderDTO.setFinishtime(new Date());
      }
        if(orderDTO.getType().equals("3")) {
            orderDTO.setStatus("3");
        }
        if(orderDTO.getType().equals("1")) {
            orderDTO.setStatus("1");
        }
        orderMapper.updateByPrimaryKeySelective(orderDTO);

        return MsgResult.success(true);
    }

    @Override
    public MsgResult<PageInfo<List<OrderDTO>>> getall(Integer pn) {

        PageHelper.startPage(pn,5);
        List<OrderDTO> list = orderMapper.page();
        PageInfo pageInfo = new PageInfo(list,5);
        //System.out.println(pageInfo);
        return MsgResult.success(pageInfo).add("orderlist",pageInfo);

    }
}
