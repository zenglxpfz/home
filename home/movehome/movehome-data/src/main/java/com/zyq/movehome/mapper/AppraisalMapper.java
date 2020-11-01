package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.AppraisalDTO;
import com.zyq.movehome.dto.AppraisalNewDTO;
import io.swagger.models.auth.In;

import java.util.List;

public interface AppraisalMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(AppraisalNewDTO record);

    int insertSelective(AppraisalNewDTO record);

    AppraisalDTO selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(AppraisalDTO record);

    int updateByPrimaryKey(AppraisalDTO record);

    List<AppraisalDTO> selectAll(AppraisalDTO appraisalDTO);

    List<AppraisalDTO> selectByoid(Integer oid);

    //根据zid查询用户发布的通知评论
    List<AppraisalDTO> selectByBid(Integer zid);

    int delectByzid(Integer zid);

    Integer selectcountByzid(Integer bid);

    Integer selectcountByoid(Integer oid);
}