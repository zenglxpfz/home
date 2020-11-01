package com.zyq.movehome.service;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.ContentDTO;
import com.zyq.movehome.dto.ContentNewDTO;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
public interface ContentService {

    MsgResult<Boolean> addContent(ContentNewDTO contentNewDTO);

    MsgResult<List<ContentDTO>> selectBytid(Integer tid);

    MsgResult<ContentDTO> selectByid(Integer id);

   // MsgResult<PageInfo<List<ContentDTO>>> selectPage();

    MsgResult<PageInfo<List<ContentDTO>>> selectConnentList(Integer pn);

    MsgResult<Boolean> delect(ContentDTO contentDTO);

    MsgResult<Boolean> edit(ContentDTO contentDTO);
}
