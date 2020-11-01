package com.zyq.movehome.serviceImpl;

import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.MhuifuDTO;
import com.zyq.movehome.dto.TeamDTO;
import com.zyq.movehome.dto.UserDTO;
import com.zyq.movehome.mapper.MhuifuMapper;
import com.zyq.movehome.mapper.TeamMapper;
import com.zyq.movehome.mapper.UserMapper;
import com.zyq.movehome.mapper.UserserviceMapper;
import com.zyq.movehome.service.MhuifuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/3/22 - 3:39
 */
@Service
public class MhuifuServiceImpl implements MhuifuService {

    @Autowired
    MhuifuMapper mhuifuMapper;

    @Autowired
    UserMapper userMapper;
    @Autowired
    TeamMapper teamMapper;
    @Override
    public MsgResult<Boolean> insert(MhuifuDTO huifuDTO) {
        huifuDTO.setCreatetime(new Date());
        mhuifuMapper.insertSelective(huifuDTO);
        //发一条信息给被回复的邮箱是usesedName
        UserDTO t = new UserDTO();
        t.setUname(huifuDTO.getUsername());
        List<UserDTO> u = userMapper.selectUser(t);
        StringBuffer s = new StringBuffer();
        //如果发送消息的人是用户，
        if(!CollectionUtils.isEmpty(u)){
     //   s.append(u.get(0).getUname()+"用户回复了您一条信息，赶紧去查看！！");
//
        }
        else {
          //  s.append(huifuDTO+"团队回复了您一条信息，赶紧去查看！！");
//
        }
        UserDTO h = new UserDTO();
        h.setUname(huifuDTO.getUseredname());
        List<UserDTO> usered = userMapper.selectUser(h);
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTname(huifuDTO.getUseredname());
        TeamDTO teamDTO1 = teamMapper.selectTeam(teamDTO);
        String a = new String();
        //如果收消息的人是用户，
        if(!CollectionUtils.isEmpty(usered)){
            //   s.append(u.get(0).getUname()+"用户回复了您一条信息，请您去查看！！");
          // a=u.get(0).getEmail();
        }
        else {
            //  s.append(huifuDTO+"团队回复了您一条信息，请您去查看！！");
     //a=teamDTO1.getTemail();
        }

//        EmailUtil  emitUtil = new EmailUtil();
//        emitUtil.sendEamilCode(a,"回复通知",s.toString());

        return MsgResult.success(true);
    }

    @Override
    public MsgResult<List<MhuifuDTO>> select(MhuifuDTO huifuplDTO) {
        return null;
    }

    @Override
    public MsgResult<MhuifuDTO> selectBykey(Integer aid) {
        return null;
    }

    @Override
    public MsgResult<Boolean> delect(Integer mid) {
        mhuifuMapper.deleteByPrimaryKey(mid);
        return MsgResult.success(true);
    }
}
