package com.zyq.movehome.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.ContentDTO;
import com.zyq.movehome.dto.ContentNewDTO;
import com.zyq.movehome.dto.UserserviceDTO;
import com.zyq.movehome.mapper.ContentMapper;
import com.zyq.movehome.service.ContentService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentMapper contentMapper;

    @Override
    public MsgResult<Boolean> addContent(ContentNewDTO contentNewDTO) {

        contentMapper.insertSelective(contentNewDTO);
        return MsgResult.success(true);
    }

    @Override
    public MsgResult<List<ContentDTO>> selectBytid(Integer tid) {
        List<ContentDTO> list = contentMapper.selectByTid(tid);
        return MsgResult.success(list);
    }

    @Override
    public MsgResult<ContentDTO> selectByid(Integer id) {
        ContentDTO contentDTO = contentMapper.selectByPrimaryKey(id);
        return MsgResult.success(contentDTO);
    }

    /**
     *分页查询规则
     */
    @Logger
    @Override
    public MsgResult<PageInfo<List<ContentDTO>>> selectConnentList(Integer pn) {
        PageHelper.startPage(pn,5);
        List<ContentDTO> list1 = contentMapper.selectPage();
        PageInfo<List<ContentDTO>> pageInfo = new PageInfo(list1,5);
        return MsgResult.success(pageInfo);

    }

    @Override
    public MsgResult<Boolean> delect(ContentDTO contentDTO) {
        contentMapper.deleteByPrimaryKey(contentDTO.getCid());
        return MsgResult.success(true);
    }

    @Override
    public MsgResult<Boolean> edit(ContentDTO contentDTO) {
        contentMapper.updateByPrimaryKey(contentDTO);
        return  MsgResult.success(true);
    }
}
