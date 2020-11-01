package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.NoticeDTO;
import com.zyq.movehome.dto.SouDTO;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(NoticeDTO record);

    int insertSelective(NoticeDTO record);

    NoticeDTO selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(NoticeDTO record);

    int updateByPrimaryKey(NoticeDTO record);

    List<NoticeDTO> selectlist(NoticeDTO noticeDTO);

    NoticeDTO selective(NoticeDTO noticeDTO);

    List<NoticeDTO> selectbysoukey(SouDTO souDTO);
}