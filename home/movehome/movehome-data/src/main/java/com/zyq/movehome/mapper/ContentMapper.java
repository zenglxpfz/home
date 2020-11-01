package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.ContentDTO;
import com.zyq.movehome.dto.ContentNewDTO;

import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(ContentNewDTO record);

    int insertSelective(ContentNewDTO record);

    ContentDTO selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(ContentDTO record);

    int updateByPrimaryKey(ContentDTO record);

    List<ContentDTO> selectByTid(Integer tid);

    List<ContentDTO> selectPage();

//    List<ContentDTO> seletcBytid(ContentDTO contentDTO);
}