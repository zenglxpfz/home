package com.zyq.movehome.service;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:47
 */
public interface TeamService {

    MsgResult<Boolean> createTeam(TeamNewDTO teamDTO);

    //查看个人团队信息,根据团队码查询
    TeamDTO selectTeam(TeamDTO teamDTO);

    //分页查询所有的团队信息，给用户看的
    MsgResult<PageInfo<List<TeamDTO>>> selectTeamlist(Integer pn);

    //添加团队成员，就是说把队长的团队码传输给另外一个用户，根据用户名查找更改其他用户的团队码，
    MsgResult<Boolean> addchengyuan(UserserviceDTO userserviceDTO);

    //查询最新团队
    MsgResult<List<TeamDTO>> selectNew(TeamDTO teamDTO);
    //查询订单最多的团队
    MsgResult<List<TeamDTO>> selectTop(TeamDTO teamDTO);

    MsgResult<Boolean> updateLikes(Integer tid);

    TeamDTO selectOrderteam(Integer tid);

    MsgResult<Boolean> delect(TeamDTO teamDTO);

    MsgResult<TeamDTO> selectbycode(TeamDTO teamDTO);

    MsgResult<Boolean> delectchengyuan(Integer tid, Integer uid);

    MsgResult<Boolean> edit(TeamDTO teamDTO);


    MsgResult<PageInfo<List<TeamDTO>>> selectbykey(SouDTO souDTO);
}
