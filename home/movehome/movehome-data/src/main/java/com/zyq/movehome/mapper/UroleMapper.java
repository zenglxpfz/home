package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.UroleDTO;

public interface UroleMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(UroleDTO record);

    int insertSelective(UroleDTO record);

    UroleDTO selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(UroleDTO record);

    int updateByPrimaryKey(UroleDTO record);
}