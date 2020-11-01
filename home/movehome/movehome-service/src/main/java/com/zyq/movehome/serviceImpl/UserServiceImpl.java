package com.zyq.movehome.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.HomeEnums;
import com.zyq.movehome.common.MsgResult;import com.zyq.movehome.dto.UroleDTO;
import com.zyq.movehome.dto.UserDTO;
import com.zyq.movehome.dto.UserNewDTO;
import com.zyq.movehome.dto.UserserviceDTO;
import com.zyq.movehome.mapper.UroleMapper;
import com.zyq.movehome.mapper.UserMapper;
import com.zyq.movehome.service.UserService;
import com.zyq.movehome.util.AppException;
import com.zyq.movehome.util.ParamValidate;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:49
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UroleMapper uroleMapper;

    @Logger
    @Override
    @ParamValidate(argsIndexs={0})
    @Transactional(rollbackFor = {Exception.class})
    public MsgResult<Boolean> addUser(UserNewDTO userNewDTO) {

        UserDTO userDTO = new UserDTO();
       // BeanUtils.copyProperties(userNewDTO,userDTO);
       // userDTO.setUname(userNewDTO.getUname());
        userDTO.setIdentity(userNewDTO.getIdentity());
        List<UserDTO> userDTOList = userMapper.selectUser(userDTO);
        //判断列表中是否有新增的用户
        if(!CollectionUtils.isEmpty(userDTOList)){
                    return MsgResult.fail(HomeEnum.SystemCode.EXIST_USER.code,HomeEnum.SystemCode.EXIST_USER.message);
                }
        UserDTO userDTO1 = new UserDTO();
        // BeanUtils.copyProperties(userNewDTO,userDTO);
        userDTO1.setUname(userNewDTO.getUname());
       // userDTO.setIdentity(userNewDTO.getIdentity());
        List<UserDTO> userDTOList1 = userMapper.selectUser(userDTO);
        //判断列表中是否有新增的用户
        if(!CollectionUtils.isEmpty(userDTOList1)){
            return MsgResult.fail(HomeEnum.SystemCode.EXIST_USER.code,HomeEnum.SystemCode.EXIST_USER.message);
        }
      try {
          //设置注册时间
          userNewDTO.setRegistrationtime(new Date());
          //设置状态
          userNewDTO.setStatus(HomeEnums.Status.YES.getCode());
         int id = userMapper.insertSelective(userNewDTO);
          //添加角色表
          UroleDTO uroleDTO = new UroleDTO();
          //设置用户id
          uroleDTO.setUid(id);
          //设置角色id为需要服务用户
          uroleDTO.setRid(3);
          uroleMapper.insertSelective(uroleDTO);
          return MsgResult.success(true);


      }catch (Exception e) {
          throw new AppException(HomeEnum.SystemCode.System_ERROR.code);
      }
     }

     //分页查询所有用户
    @Override
    public MsgResult<PageInfo<List<UserDTO>>> selectUserList(Integer pn) {

//        if(pn==0){
//            pn=1;
//        }
        PageHelper.startPage(pn,5);
        List<UserDTO> list = userMapper.selectUser(null);
        PageInfo pageInfo = new PageInfo(list,5);
      //System.out.println(pageInfo);
        return MsgResult.success(pageInfo).add("list",pageInfo);
    }

    @Override
    public UserDTO selectUserBynameAndpassword(UserDTO userDTO) {

        return userMapper.selectUserBynameAndpassword(userDTO);

    }

    @Override
    public MsgResult<Boolean> update(UserDTO userDTO) {

         userMapper.updateByPrimaryKeySelective(userDTO);
         return MsgResult.success(true);
    }

    @Override
    public MsgResult<UserDTO> selectUserByUid(UserDTO userDTO) {
      System.out.println(userDTO.getUid());
       UserDTO userDTO1 = userMapper.selectByPrimaryKey(userDTO.getUid());
        return MsgResult.success(userDTO1);
    }

    @Override
    public MsgResult<Boolean> delect(UserDTO userDTO) {
       // UserDTO userserviceDTO1 = userserviceMapper.selectByPrimaryKey(userserviceDTO.getUid());
        // if(StringUtils.isEmpty(userserviceDTO1.getCode()))


        userMapper.deleteByPrimaryKey(userDTO.getUid());

        return MsgResult.success(true);
    }
}
