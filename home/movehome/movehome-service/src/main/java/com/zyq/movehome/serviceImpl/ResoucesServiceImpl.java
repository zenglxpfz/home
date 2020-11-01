package com.zyq.movehome.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.ResoucesDTO;
import com.zyq.movehome.dto.ResoucesNewDTO;
import com.zyq.movehome.dto.TeamDTO;
import com.zyq.movehome.mapper.ResoucesMapper;
import com.zyq.movehome.service.ResoucesService;
import com.zyq.movehome.util.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:47
 */
@Service
public class ResoucesServiceImpl implements ResoucesService {
    @Autowired
    ResoucesMapper resoucesMapper;

    @Override
    public MsgResult<Boolean> addResouse(ResoucesNewDTO resoucesNewDTO) {


        resoucesMapper.insertSelective(resoucesNewDTO);

        return MsgResult.success(true);
    }

    @Override
    public MsgResult<ResoucesDTO> selectone(Integer id) {
        try {
            ResoucesDTO resoucesDTO = resoucesMapper.selectByPrimaryKey(id);

            return MsgResult.success(resoucesDTO);
        }catch (Exception e){
            throw new AppException(HomeEnum.SystemCode.ERROR_SELECT_RESOUCES.message);

        }

    }

    //分页查询资源表
    @Override
    public MsgResult<PageInfo<List<ResoucesDTO>>> selectResouceslist(Integer pn,Integer tid) {

        if(tid==null) {
            PageHelper.startPage(pn,5);
            List<ResoucesDTO> list = resoucesMapper.selectList(null);
            PageInfo<List<ResoucesDTO>> pageInfo = new PageInfo(list,5);
            return MsgResult.success(pageInfo);
        }
        ResoucesDTO resoucesDTO = new ResoucesDTO();
        resoucesDTO.setTid(tid);
        PageHelper.startPage(pn,5);
        List<ResoucesDTO> list = resoucesMapper.selectList(resoucesDTO);
        PageInfo<List<ResoucesDTO>> pageInfo = new PageInfo(list,5);
        return MsgResult.success(pageInfo);

    }

    @Override
    public MsgResult<Boolean> delect(ResoucesDTO resoucesDTO) {
        resoucesMapper.deleteByPrimaryKey(resoucesDTO.getRid());
        return MsgResult.success(true);
    }

    @Override
    public MsgResult<Boolean> update(ResoucesDTO resoucesDTO) {
        resoucesMapper.updateByPrimaryKeySelective(resoucesDTO);
        return MsgResult.success(true);
    }

    //查询个人团队的所有资源
//    @Override
//    public MsgResult<PageInfo<List<ResoucesDTO>>> selectlist(Integer pn,Integer tid) {
//        PageHelper.startPage(pn,10);
//        ResoucesDTO resoucesDTO = new ResoucesDTO();
//        resoucesDTO.setTid(tid);
//        List<ResoucesDTO> list = resoucesMapper.selectList(resoucesDTO);
//        PageInfo<List<ResoucesDTO>> pageInfo = new PageInfo(list,5);
//        return MsgResult.success(pageInfo);
//
//    }
}
