package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.UserDTO;
import com.zyq.movehome.dto.UserNewDTO;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserNewDTO userNewDTO);

    int insertSelective(UserNewDTO record);

    UserDTO selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);

    //查询用户列表
    List<UserDTO> selectUser(UserDTO userDTO);

    UserDTO selectUserBynameAndpassword(UserDTO userDTO);
}