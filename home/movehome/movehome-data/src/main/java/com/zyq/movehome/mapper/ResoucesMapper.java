package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.ResoucesDTO;
import com.zyq.movehome.dto.ResoucesNewDTO;

import java.util.List;

public interface ResoucesMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(ResoucesNewDTO record);

    int insertSelective(ResoucesNewDTO record);

    ResoucesDTO selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(ResoucesDTO record);

    int updateByPrimaryKey(ResoucesDTO record);

    List<ResoucesDTO> selectList(ResoucesDTO resoucesDTO);
}