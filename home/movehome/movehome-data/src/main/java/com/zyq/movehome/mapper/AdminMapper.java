package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.AdminDTO;
import com.zyq.movehome.dto.loanApply.CustomerManagerGetDTO;
import com.zyq.movehome.dto.loanApply.CustomerManagerResultDTO;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminDTO record);

    int insertSelective(AdminDTO record);

    AdminDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminDTO record);

    int updateByPrimaryKey(AdminDTO record);

    AdminDTO selectBynameAndpassword(AdminDTO adminDTO);

    //根据二维码传来的id查询二维码表，拿到客户经理的信息，并进行校验
    CustomerManagerResultDTO selectById(CustomerManagerGetDTO customerManagerGetDTO);
}