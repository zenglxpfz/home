package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.SouDTO;
import com.zyq.movehome.dto.TeamDTO;
import com.zyq.movehome.dto.TeamNewDTO;

import java.util.List;

public interface TeamMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(TeamDTO record);

    int insertSelective(TeamNewDTO teamNewDTO);

    TeamDTO selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(TeamDTO record);

    int updateByPrimaryKey(TeamDTO record);

    List<TeamDTO> selectAll(TeamDTO teamDTO);

    TeamDTO selectTeam(TeamDTO teamDTO);

    List<TeamDTO> selectTop(TeamDTO teamDTO);

    List<TeamDTO> selectNew(TeamDTO teamDTO);

    TeamDTO selectByCode(TeamDTO teamDTO);

    List<TeamDTO> selectbykey(SouDTO souDTO);

}