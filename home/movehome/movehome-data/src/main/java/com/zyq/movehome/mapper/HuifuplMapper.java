package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.HuifuplDTO;
import io.swagger.models.auth.In;

import java.util.List;

public interface HuifuplMapper {

    int deleteByPrimaryKey(Integer aid);

    int insert(HuifuplDTO record);

    int insertSelective(HuifuplDTO record);

    HuifuplDTO selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(HuifuplDTO record);

    int updateByPrimaryKey(HuifuplDTO record);

    List<HuifuplDTO> selectbyFid(Integer aid);

    int deleceByfid(Integer aid);

    int selectcountByFid(Integer fid);
}