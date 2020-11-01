package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.RoleDTO;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(RoleDTO record);

    int insertSelective(RoleDTO record);

    RoleDTO selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(RoleDTO record);

    int updateByPrimaryKey(RoleDTO record);
}