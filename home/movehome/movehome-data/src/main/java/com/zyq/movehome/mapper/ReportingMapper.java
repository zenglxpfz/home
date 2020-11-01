package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.ReportingDTO;

public interface ReportingMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(ReportingDTO record);

    int insertSelective(ReportingDTO record);

    ReportingDTO selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(ReportingDTO record);

    int updateByPrimaryKey(ReportingDTO record);
}