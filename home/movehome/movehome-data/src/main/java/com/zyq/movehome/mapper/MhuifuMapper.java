package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.HuifuplDTO;
import com.zyq.movehome.dto.MhuifuDTO;

import java.util.List;

public interface MhuifuMapper {

    int deleteByPrimaryKey(Integer mid);

    int insert(MhuifuDTO record);

    int insertSelective(MhuifuDTO record);

    MhuifuDTO selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(MhuifuDTO record);

    int updateByPrimaryKey(MhuifuDTO record);

    List<MhuifuDTO> selectbyFid(Integer mid);

    int deleceByfid(Integer mid);

    //int deleteByFid(Integer fid);
}