package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.MessageDTO;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(MessageDTO record);

    int insertSelective(MessageDTO record);

    MessageDTO selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(MessageDTO record);

    int updateByPrimaryKey(MessageDTO record);

    List<MessageDTO> selectByselective(MessageDTO messageDTO);

    List<MessageDTO> page();
}