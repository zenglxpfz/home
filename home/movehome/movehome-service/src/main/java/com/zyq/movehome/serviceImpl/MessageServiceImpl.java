package com.zyq.movehome.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.HomeEnums;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.MessageMapper;
import com.zyq.movehome.mapper.MhuifuMapper;
import com.zyq.movehome.mapper.TeamMapper;
import com.zyq.movehome.mapper.UserMapper;
import com.zyq.movehome.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.EmitUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    MhuifuMapper mhuifuMapper;

    @Autowired
    TimeServiceImpl timeService;

    @Override
    public MsgResult<List<MessageDTO>> add(MessageDTO messageDTO) {
        messageDTO.setCreatetime(new Date());
        messageDTO.setStatus(HomeEnums.Status.YES.getCode());
       messageMapper.insertSelective(messageDTO);
       MessageDTO messageDTO1 = new MessageDTO();
       messageDTO1.setTid(messageDTO.getTid());
       messageDTO1.setUid(messageDTO.getUid());
       List<MessageDTO> list = messageMapper.selectByselective(messageDTO1);
       for(MessageDTO m : list){
           TeamDTO teamDTO = teamMapper.selectByPrimaryKey(m.getTid());
           UserDTO userDTO = userMapper.selectByPrimaryKey(m.getUid());
           m.setTname(teamDTO.getTname());
           m.setUname(userDTO.getUname());
       }
      // List<>
        UserDTO d = userMapper.selectByPrimaryKey(messageDTO.getUid());
        //发送邮件
TeamDTO teamDTO = teamMapper.selectByPrimaryKey(messageDTO.getTid());


//        StringBuffer s = new StringBuffer();
//         s.append(d.getUname()+"用户给您团队留言啦，请您去查看！");
//        EmailUtil  emitUtil = new EmailUtil();
//        emitUtil.sendEamilCode(teamDTO.getTemail(),"留言通知",s.toString());
        return MsgResult.success(list);
    }

    @Override
    public MsgResult<List<MessageDTO>> selectBytiduid(MessageDTO messageDTO) {
        //1/根据uid查询客户自己的所有留言
        List<MessageDTO> list = messageMapper.selectByselective(messageDTO);


        for(MessageDTO m : list){
            TeamDTO teamDTO = teamMapper.selectByPrimaryKey(m.getTid());
            UserDTO userDTO = userMapper.selectByPrimaryKey(m.getUid());
            m.setTname(teamDTO.getTname());
            m.setUname(userDTO.getUname());
            String a = timeService.format(m.getCreatetime());
            m.setTime(a);
        }
        for(MessageDTO l : list){
            MhuifuDTO huifuplDTO = new MhuifuDTO();
            huifuplDTO.setFid(l.getMid());
            List<MhuifuDTO> list1 = new ArrayList<>();

            list1 = mhuifuMapper.selectbyFid(l.getMid());

            if(!CollectionUtils.isEmpty(list1)){
                l.setMhuifuDTOS(list1);
                l.setCountpl(list1.size());
            }else{
                l.setMhuifuDTOS(list1);
                l.setCountpl(0);
            }
        }
        return MsgResult.success(list);
    }

    @Override
    public MsgResult<List<MessageDTO>> delect(MessageDTO messageDTO) {
        messageMapper.deleteByPrimaryKey(messageDTO.getMid());
        mhuifuMapper.deleceByfid(messageDTO.getMid());
        MessageDTO messageDTO1 = new MessageDTO();
        messageDTO1.setTid(messageDTO.getTid());
        messageDTO1.setUid(messageDTO.getUid());
        List<MessageDTO> list = messageMapper.selectByselective(messageDTO1);
        for(MessageDTO m : list){
            TeamDTO teamDTO = teamMapper.selectByPrimaryKey(m.getTid());
            UserDTO userDTO = userMapper.selectByPrimaryKey(m.getUid());
            m.setTname(teamDTO.getTname());
            m.setUname(userDTO.getUname());
        }
        return MsgResult.success(list);
    }

    @Override
    public MsgResult<List<MessageDTO>> selectmy(MessageDTO messageDTO) {
        List<MessageDTO> list = messageMapper.selectByselective(messageDTO);
        for(MessageDTO m : list){
            TeamDTO teamDTO = teamMapper.selectByPrimaryKey(m.getTid());
            UserDTO userDTO = userMapper.selectByPrimaryKey(m.getUid());
            m.setTname(teamDTO.getTname());
            m.setUname(userDTO.getUname());
        }
        return MsgResult.success(list);
    }

    @Override
    public MsgResult<PageInfo<List<MessageDTO>>> page(Integer pn) {


        PageHelper.startPage(pn,5);
        List<MessageDTO> list = messageMapper.page();
        PageInfo<List<MessageDTO>> pageInfo = new PageInfo(list,5);
        return MsgResult.success(pageInfo);
    }

    @Override
    public MsgResult<Boolean> delects(MessageDTO messageDTO) {
        messageMapper.deleteByPrimaryKey(messageDTO.getMid());
        return MsgResult.success(true);
    }
}
