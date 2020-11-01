package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.ApplyDTO;

import java.util.List;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer applyid);

    int insert(ApplyDTO record);

    int insertSelective(ApplyDTO record);

    ApplyDTO selectByPrimaryKey(Integer applyid);

    int updateByPrimaryKeySelective(ApplyDTO record);

    int updateByPrimaryKey(ApplyDTO record);

    List<ApplyDTO> selectByUnameOrTname(ApplyDTO applyDTO);
}