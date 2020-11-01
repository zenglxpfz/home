package com.zyq.movehome.service;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.MessageDTO;
import com.zyq.movehome.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
public interface MessageService {

    MsgResult<List<MessageDTO>> add(MessageDTO messageDTO);

    MsgResult<List<MessageDTO>> selectBytiduid(MessageDTO messageDTO);

    MsgResult<List<MessageDTO>> delect(MessageDTO messageDTO);

    MsgResult<List<MessageDTO>> selectmy(MessageDTO messageDTO);

    MsgResult<PageInfo<List<MessageDTO>>> page(Integer pn);

    MsgResult<Boolean> delects(MessageDTO messageDTO);
}
