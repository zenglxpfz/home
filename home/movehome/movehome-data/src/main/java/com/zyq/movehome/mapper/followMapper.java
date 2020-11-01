package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.followNewDTO;

public interface followMapper {
    int deleteByPrimaryKey(String id);

    int insert(followNewDTO record);

    int insertSelective(followNewDTO record);

    followNewDTO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(followNewDTO record);

    int updateByPrimaryKey(followNewDTO record);
}