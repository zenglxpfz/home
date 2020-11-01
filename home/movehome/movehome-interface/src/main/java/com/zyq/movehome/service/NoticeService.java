package com.zyq.movehome.service;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
public interface NoticeService {

    MsgResult<Boolean> addNotice(NoticeDTO contentNewDTO);


    MsgResult<NoticeDTO> selectByid(Integer bid);

    MsgResult<NoticeDTO> selectis(NoticeDTO noticeDTO);


    MsgResult<PageInfo<List<NoticeDTO>>> selectNoticeList(Integer pn);

    MsgResult<Boolean> delect1(NoticeDTO contentDTO);

    MsgResult<Boolean> edit(NoticeDTO contentDTO);

    MsgResult<Boolean> delect(Integer bid);

    MsgResult<Boolean> addpl(AppraisalDTO dto);

    MsgResult<PageInfo<List<NoticeDTO>>> selectbykey(SouDTO souDTO);

}
