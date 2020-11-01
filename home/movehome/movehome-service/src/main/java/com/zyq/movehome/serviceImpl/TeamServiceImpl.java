package com.zyq.movehome.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.HomeEnums;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.OrderMapper;
import com.zyq.movehome.mapper.TeamMapper;
import com.zyq.movehome.mapper.UserserviceMapper;
import com.zyq.movehome.service.TeamService;
import com.zyq.movehome.util.AppException;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.mail.Session;
import java.sql.Array;
import java.util.*;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:47
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    UserserviceMapper userserviceMapper;

    @Autowired
    OrderMapper orderMapper;

    @Logger
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public MsgResult<Boolean> createTeam(TeamNewDTO teamDTO) {


            teamMapper.insertSelective(teamDTO);
           return MsgResult.success(true);

    }

    //根据团队码查询个人团队信息
    @Override
    public TeamDTO selectTeam(TeamDTO teamDTO) {
        return teamMapper.selectTeam(teamDTO);
    }

    //分页查询团队列表
    @Override
    public MsgResult<PageInfo<List<TeamDTO>>> selectTeamlist(Integer pn) {
        PageHelper.startPage(pn, 3);
        List<TeamDTO> list = teamMapper.selectAll(null);
        Page page = (Page) list;
        int pageSize = page.getPageSize();
        long total = page.getTotal();
        List result = page.getResult();
        Integer i = 0;
        for (TeamDTO teamDTO : list){
            i= orderMapper.selectcount(teamDTO.getTname());
            if (i==null){
            teamDTO.setOrders(0);
            }else{
                teamDTO.setOrders(i);
            }
        }
        PageInfo<List<TeamDTO>> pageInfo = new PageInfo(list,10);
        return MsgResult.success(pageInfo);
    }

    @Override
    public MsgResult<Boolean> addchengyuan(UserserviceDTO userserviceDTO) {
        userserviceMapper.updateByPrimaryKeySelective(userserviceDTO);
        return MsgResult.success(true);
    }

    //查询最新的团队
    @Override
    public MsgResult<List<TeamDTO>> selectNew(TeamDTO teamDTO) {

        List<TeamDTO> list = teamMapper.selectNew(null);

        return MsgResult.success(list);
    }

    @Override
    public MsgResult<List<TeamDTO>> selectTop(TeamDTO teamDTO) {
        TeamDTO teamDTO1 = new TeamDTO();
        List<TorderTeamResult> list = orderMapper.selectTopOrder(null);
        List<String> tnames = new ArrayList<>();
        Integer i = 0;
        List<Integer> orders = new ArrayList<>();
        Map<String,Integer> or = new HashMap<>();
        for(TorderTeamResult t :list){
            tnames.add(t.getTname());
            i =  orderMapper.selectcount(t.getTname());
            or.put(t.getTname(),i);
            t.setCount(i);
        }
        teamDTO1.setTnames(tnames);
        List<TeamDTO> list1 = teamMapper.selectTop(teamDTO1);
        for (TeamDTO l:list1){
            i= orderMapper.selectcount(l.getTname());
                   l.setOrders(i);
        }
        return MsgResult.success(list1);
    }

    //点赞加一
    @Override
    public MsgResult<Boolean> updateLikes(Integer tid) {
        TeamDTO teamDTO = teamMapper.selectByPrimaryKey(tid);
        TeamDTO teamDTO1 = new TeamDTO();
        teamDTO1.setTlikes(teamDTO.getTlikes()+1);
        teamDTO1.setTid(tid);
        teamMapper.updateByPrimaryKey(teamDTO1);
        return MsgResult.success(true);
    }

    @Override
    public TeamDTO selectOrderteam(Integer tid) {
        TeamDTO teamDTO = teamMapper.selectByPrimaryKey(tid);
        return teamDTO;
    }

    @Override
    public MsgResult<Boolean> delect(TeamDTO teamDTO) {
        teamMapper.deleteByPrimaryKey(teamDTO.getTid());
        return MsgResult.success(true);
    }

    //根据团队码查询团队信息
    @Override
    public MsgResult<TeamDTO> selectbycode(TeamDTO teamDTO) {
        TeamDTO teamDTO1 = teamMapper.selectByCode(teamDTO);
        return MsgResult.success(teamDTO1);
    }

    //删除成员
    @Override
    public MsgResult<Boolean> delectchengyuan(Integer tid, Integer uid) {

        TeamDTO teamDTO = teamMapper.selectByPrimaryKey(tid);
        Long tperson = teamDTO.getTperson();
        tperson--;
        teamDTO.setTperson(tperson);
        teamMapper.updateByPrimaryKeySelective(teamDTO);


        UserserviceDTO userserviceDTO = userserviceMapper.selectByPrimaryKey(uid);
        userserviceDTO.setCode("0");
        userserviceDTO.setRole(null);
        userserviceMapper.updateByPrimaryKeySelective(userserviceDTO);

        return MsgResult.success(true);

    }

    @Override
    public MsgResult<Boolean> edit(TeamDTO teamDTO) {
        teamMapper.updateByPrimaryKeySelective(teamDTO);
        return MsgResult.success(true);
    }

    @Override
    public MsgResult<PageInfo<List<TeamDTO>>> selectbykey(SouDTO souDTO) {
        PageHelper.startPage(souDTO.getPn(),4);
        List<TeamDTO> selectbykey = teamMapper.selectbykey(souDTO);
        Integer i = 0;
        for (TeamDTO teamDTO : selectbykey){
            i= orderMapper.selectcount(teamDTO.getTname());
            if (i==null){
                teamDTO.setOrders(0);
            }else{
                teamDTO.setOrders(i);
            }
        }
        PageInfo<List<TeamDTO>> pageInfo = new PageInfo(selectbykey,5);

        return MsgResult.success(pageInfo);
    }

}
