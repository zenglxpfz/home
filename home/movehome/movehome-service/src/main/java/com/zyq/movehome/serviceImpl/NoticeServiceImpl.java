package com.zyq.movehome.serviceImpl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.App;
import com.zyq.movehome.common.HomeEnums;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.*;
import com.zyq.movehome.service.ContentService;
import com.zyq.movehome.service.NoticeService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:46
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    AppraisalMapper appraisalMapper;
    @Autowired
    HuifuplMapper huifuplMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TimeServiceImpl timeService;

    //添加文章
    @Override
    public MsgResult<Boolean> addNotice(NoticeDTO noticeDTO) {

        noticeDTO.setCrieatetime(new Date());
        noticeMapper.insertSelective(noticeDTO);

        return MsgResult.success(true);
    }

    //根据id查询
    @Override
    public MsgResult<NoticeDTO> selectByid(Integer bid) {
        NoticeDTO noticeDTO = noticeMapper.selectByPrimaryKey(bid);
        UserDTO userDTO = userMapper.selectByPrimaryKey(noticeDTO.getUid());
        noticeDTO.setUserDTO(userDTO);
        Integer i = appraisalMapper.selectcountByzid(bid);
        if(i==null){
            noticeDTO.setCountpl(0);
        }else {
            noticeDTO.setCountpl(i);
        }
        return MsgResult.success(noticeDTO);
    }

    //根据条件查询
    @Override
    public MsgResult<NoticeDTO> selectis(NoticeDTO noticeDTO) {
        NoticeDTO noticeDTO1 = noticeMapper.selective(noticeDTO);
        return null;
    }

    //分页查询所有
    @Override
    public MsgResult<PageInfo<List<NoticeDTO>>> selectNoticeList(Integer pn) {


            PageHelper.startPage(pn, 4);
            List<NoticeDTO> list = noticeMapper.selectlist(null);
//        for(NoticeDTO li:list){
//            List<AppraisalDTO> list1 = appraisalMapper.selectByBid(li.getBid());
//            for(AppraisalDTO a : list1){
//                List<HuifuplDTO> list2 = huifuplMapper.selectbyFid(a.getAid());
//               a.setHuifuplDTOS(list2);
//            }
//            li.setAppraisalDTOS(list1);
//        }
            for (NoticeDTO li : list) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

               // Date date = format.parse(li.getCrieatetime() + "");

                String a = timeService.format(li.getCrieatetime());
                li.setTime(a);
                Integer x = appraisalMapper.selectcountByzid(li.getBid());
                if(x==null){
                    li.setCountpl(0);
                }
                else {
                    li.setCountpl(x);
                }
            }
            PageInfo pageInfo = new PageInfo(list, 4);
            //System.out.println(pageInfo);
            return MsgResult.success(pageInfo).add("notice", pageInfo);


    }

    //删除
    @Override
    public MsgResult<Boolean> delect1(NoticeDTO contentDTO) {
        noticeMapper.deleteByPrimaryKey(contentDTO.getBid());
        AppraisalDTO appraisalDTO = new AppraisalDTO();
        appraisalDTO.setZid(contentDTO.getBid());
        List<AppraisalDTO> appraisalDTOS = appraisalMapper.selectAll(appraisalDTO);
        for(AppraisalDTO a : appraisalDTOS){
            huifuplMapper.deleceByfid(a.getAid());
        }
        appraisalMapper.delectByzid(contentDTO.getBid());
        return MsgResult.success(true);
    }

    //修改根据id
    @Override
    public MsgResult<Boolean> edit(NoticeDTO contentDTO) {
        noticeMapper.updateByPrimaryKeySelective(contentDTO);
        return MsgResult.success(true);
    }

    @Override
    public MsgResult<Boolean> delect(Integer bid) {
        noticeMapper.deleteByPrimaryKey(bid);
        AppraisalDTO appraisalDTO = new AppraisalDTO();
        appraisalDTO.setZid(bid);
        List<AppraisalDTO> appraisalDTOS = appraisalMapper.selectAll(appraisalDTO);
        for(AppraisalDTO a : appraisalDTOS){
            huifuplMapper.deleceByfid(a.getAid());
        }
        appraisalMapper.delectByzid(bid);
        return MsgResult.success(true);
    }

    //
    @Override
    public MsgResult<Boolean> addpl(AppraisalDTO dto) {
        AppraisalNewDTO appraisalNewDTO = new AppraisalNewDTO();
        BeanUtils.copyProperties(dto,appraisalNewDTO);
        //zid----bid

        appraisalNewDTO.setType("2");
        appraisalNewDTO.setCreatetime(new Date());
        //2是团队
        if(dto.getRole().equals(HomeEnums.Role.SERVICE.getCode())){
            appraisalNewDTO.setTname(dto.getUname()+"团队");
        }else{
            appraisalNewDTO.setTname(dto.getUname());
        }
        appraisalMapper.insertSelective(appraisalNewDTO);
        return MsgResult.success(true);
    }

    @Override
    public MsgResult<PageInfo<List<NoticeDTO>>> selectbykey(SouDTO souDTO) {
        PageHelper.startPage(souDTO.getPn(), 4);
        List<NoticeDTO> list = noticeMapper.selectbysoukey(souDTO);
        for (NoticeDTO li : list) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Date date = format.parse(li.getCrieatetime() + "");

            String a = timeService.format(li.getCrieatetime());
            li.setTime(a);
            Integer x = appraisalMapper.selectcountByzid(li.getBid());
            if(x==null){
                li.setCountpl(0);
            }
            else {
                li.setCountpl(x);
            }
        }
        PageInfo pageInfo = new PageInfo(list, 4);
        //System.out.println(pageInfo);
        return MsgResult.success(pageInfo).add("notice", pageInfo);

    }

}
