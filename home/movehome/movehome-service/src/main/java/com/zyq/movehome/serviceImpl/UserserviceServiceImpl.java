package com.zyq.movehome.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.HomeEnums;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.TeamMapper;
import com.zyq.movehome.mapper.UroleMapper;
import com.zyq.movehome.mapper.UserserviceMapper;
import com.zyq.movehome.service.UserserviceService;
import com.zyq.movehome.util.AppException;
import com.zyq.movehome.util.ParamValidate;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:49
 */
@Service
public class UserserviceServiceImpl implements UserserviceService {

    @Autowired
    UserserviceMapper userserviceMapper;
    @Autowired
    UroleMapper uroleMapper;
    @Autowired
    TeamMapper teamMapper;
    @Override
    @ParamValidate(argsIndexs = {0})
    @Logger
    @Transactional(rollbackFor={Exception.class})
    public MsgResult<Boolean> addUserservice(UserserviceNewDTO userserviceNewDTO) {
        UserserviceDTO userserviceDTO = new UserserviceDTO();
      //  userserviceDTO.setUname(userserviceNewDTO.getUname());
        userserviceDTO.setIdentity(userserviceNewDTO.getIdentity());
        List<UserserviceDTO> list = userserviceMapper.selectUserservice(userserviceDTO);
        if(list!=null&&list.size()>0){
            return MsgResult.fail(HomeEnum.SystemCode.EXIST_USER.code,HomeEnum.SystemCode.EXIST_USER.message);

        }
        UserserviceDTO userserviceDTO1 = new UserserviceDTO();
        userserviceDTO1.setUname(userserviceNewDTO.getUname());
       // userserviceDTO.setIdentity(userserviceNewDTO.getIdentity());
        List<UserserviceDTO> list1 = userserviceMapper.selectUserservice(userserviceDTO);
        if(list1!=null&&list1.size()>0){
            return MsgResult.fail(HomeEnum.SystemCode.EXIST_USER.code,HomeEnum.SystemCode.EXIST_USER.message);

        }
       try {
           //设置注册时间
           userserviceNewDTO.setRegistrationtime(new Date());
           //设置状态
           userserviceNewDTO.setStatus(HomeEnums.Status.YES.getCode());
           int uid = userserviceMapper.insertSelective(userserviceNewDTO);
            for(int i=1;i<=2;i++){
                UroleDTO uroleDTO = new UroleDTO();
                uroleDTO.setUid(uid);
                uroleDTO.setRid(i);
                uroleMapper.insertSelective(uroleDTO);
            }
       return MsgResult.success(true);
       }catch (Exception e) {
           throw new AppException(HomeEnum.SystemCode.System_ERROR.message);
       }
    }

    @Logger
    @Override
    public List<UserserviceDTO> selectListUserservice(UserserviceDTO userserviceDTO) {

        return userserviceMapper.selectUserservice(userserviceDTO);
    }

    @Override
    public UserserviceDTO selectUserserviceBynameAndpassword(UserserviceDTO userserviceDTO) {
        return userserviceMapper.selectUserserviceBynameAndpassword(userserviceDTO);
    }

    @Override
    public MsgResult<Boolean> update(UserserviceDTO userserviceDTO) {
        userserviceMapper.updateByPrimaryKeySelective(userserviceDTO);
        return MsgResult.success(true);
    }

    /**
     *分页查询用户
     */
    @Logger
    @Override
    public MsgResult<PageInfo<List<UserserviceDTO>>> selectUserserviceList(Integer pn) {
        PageHelper.startPage(pn,5);
        List<UserserviceDTO> list1 = userserviceMapper.selectUserservice(null);
        PageInfo<List<UserserviceDTO>> pageInfo = new PageInfo(list1,5);
        return MsgResult.success(pageInfo);

    }

    @Override
    public MsgResult<Boolean> delect(UserserviceDTO userserviceDTO) {
        UserserviceDTO userserviceDTO1 = userserviceMapper.selectByPrimaryKey(userserviceDTO.getUid());
       // if(StringUtils.isEmpty(userserviceDTO1.getCode()))
        userserviceMapper.deleteByPrimaryKey(userserviceDTO.getUid());

        return MsgResult.success(true);
    }

    //查询用户信息
    @Override
    public MsgResult<UserserviceDTO> selectOne(Integer uid) {
        UserserviceDTO userserviceDTO = userserviceMapper.selectByPrimaryKey(uid);
        if(!StringUtils.isEmpty(userserviceDTO.getCode())&&!userserviceDTO.getCode().equals("0")) {
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setCode(userserviceDTO.getCode());
            TeamDTO teamDTO1 = teamMapper.selectByCode(teamDTO);
            userserviceDTO.setTname(teamDTO1.getTname());
        }
        return MsgResult.success(userserviceDTO);
    }

    @Override
    public MsgResult<List<UserserviceDTO>> selectNullcode() {
        List<UserserviceDTO> userserviceDTOList = userserviceMapper.selectnullcode();
        return MsgResult.success(userserviceDTOList);
    }

    @Override
    public MsgResult<List<UserserviceDTO>> selectbykey(SouDTO souDTO) {
        List<UserserviceDTO> selectbykey = userserviceMapper.selectbykey(souDTO);
        return MsgResult.success(selectbykey);
    }
}
