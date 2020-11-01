package com.zyq.movehome.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.AppraisalMapper;
import com.zyq.movehome.mapper.HuifuplMapper;
import com.zyq.movehome.mapper.OrderMapper;
import com.zyq.movehome.mapper.UserMapper;
import com.zyq.movehome.service.AppraisalService;
import com.zyq.movehome.service.HuifuplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:44
 */
@Service
public class AppraisalImpl implements AppraisalService {

    @Autowired
    AppraisalMapper appraisalMapper;
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    HuifuplMapper huifuplMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TimeServiceImpl timeService;
    

    @Override
    public MsgResult<Boolean> addAppraisal(AppraisalNewDTO appraisalNewDTO) {
        appraisalMapper.insertSelective(appraisalNewDTO);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOid(appraisalNewDTO.getOid());
        orderDTO.setScoring(appraisalNewDTO.getScoring());
        orderMapper.updateByPrimaryKeySelective(orderDTO);
        return  MsgResult.success(true);
    }

    @Override
    public MsgResult<Boolean> delete(Integer aid) {
       appraisalMapper.deleteByPrimaryKey(aid);
       huifuplMapper.deleceByfid(aid);

        return MsgResult.success(true);
    }

    @Override
    public MsgResult<PageInfo<List<AppraisalDTO>>> selectAll(Integer pn) {

        PageHelper.startPage(pn,5);
        List<AppraisalDTO> list = appraisalMapper.selectAll(null);
        List<Integer> tids = new ArrayList<>();
        List<Integer> uids = new ArrayList<>();
        for (AppraisalDTO a : list){
            tids.add(a.getTid());
            uids.add(a.getUid());
        }
        //查询出所有团队名
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTids(tids);

        PageInfo<List<AppraisalDTO>> pageInfo = new PageInfo(list,5);

        return MsgResult.success(pageInfo);

    }

    //查询id的评论
    @Override
    public MsgResult<List<AppraisalDTO>> selectByoid(Integer oid) {
        List<AppraisalDTO> list =  appraisalMapper.selectByoid(oid);
        for(AppraisalDTO x : list){
            String a = timeService.format(x.getCreatetime());
            x.setTime(a);
            UserDTO u = new UserDTO();
            UserDTO userDTO = userMapper.selectByPrimaryKey(x.getUid());
            x.setUname(userDTO.getUname());
        }

        for(AppraisalDTO l : list){
            HuifuplDTO huifuplDTO = new HuifuplDTO();
            huifuplDTO.setFid(l.getAid());
            List<HuifuplDTO> list1 = new ArrayList<>();
            //Integer i = huifuplMapper.selectcountByFid(l.getAid());

          list1 = huifuplMapper.selectbyFid(l.getAid());
            l.setCounthuif(list1.size());
            for(HuifuplDTO hui : list1){
                String a = timeService.format(hui.getCreatetime());
                hui.setTime(a);

            }
          if(!CollectionUtils.isEmpty(list1)){
          l.setHuifuplDTOS(list1);
          }
        }
        return MsgResult.success(list);
    }

    //根据zid的查询评论
    @Override
    public MsgResult<List<AppraisalDTO>> selectByZid(Integer zid) {
        List<AppraisalDTO> list =  appraisalMapper.selectByBid(zid);
        for(AppraisalDTO x : list){
            String a = timeService.format(x.getCreatetime());
            x.setTime(a);
        //    UserDTO u = new UserDTO();
       //     UserDTO userDTO = userMapper.selectByPrimaryKey(x.getUid());
        //    x.setUname(userDTO.getUname());
        }

        for(AppraisalDTO l : list){
            HuifuplDTO huifuplDTO = new HuifuplDTO();
            huifuplDTO.setFid(l.getAid());
            List<HuifuplDTO> list1 = new ArrayList<>();
            list1 = huifuplMapper.selectbyFid(l.getAid());
            for(HuifuplDTO hui : list1){
                String a = timeService.format(hui.getCreatetime());
                hui.setTime(a);
            }
          //  if(!CollectionUtils.isEmpty(list1)){
                l.setCounthuif(list1.size());
                l.setHuifuplDTOS(list1);
        }
        return MsgResult.success(list);
    }

    @Override
    public MsgResult<Boolean> delect(AppraisalDTO appraisalDTO) {

        appraisalMapper.deleteByPrimaryKey(appraisalDTO.getAid());
        return MsgResult.success(true);
    }
}
