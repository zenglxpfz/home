package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.SouDTO;
import com.zyq.movehome.dto.TeamDTO;
import com.zyq.movehome.dto.UserserviceDTO;
import com.zyq.movehome.dto.UserserviceNewDTO;

import java.util.List;

public interface UserserviceMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserserviceDTO record);

    int insertSelective(UserserviceNewDTO record);

    UserserviceDTO selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserserviceDTO record);

    int updateByPrimaryKey(UserserviceDTO record);
    //查询列表根据条件
    List<UserserviceDTO>  selectUserservice(UserserviceDTO userserviceDTO);

    //查询用户登录
    UserserviceDTO selectUserserviceBynameAndpassword(UserserviceDTO userserviceDTO);

    //查询没有团队码的用户
    List<UserserviceDTO> selectnullcode();

    List<UserserviceDTO> selectbykey(SouDTO souDTO);

}