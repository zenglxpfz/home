package com.zyq.movehome.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.HomeEnums;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.ApplyDTO;
import com.zyq.movehome.dto.TeamDTO;
import com.zyq.movehome.dto.UserserviceDTO;
import com.zyq.movehome.mapper.ApplyMapper;
import com.zyq.movehome.mapper.TeamMapper;
import com.zyq.movehome.mapper.UserserviceMapper;
import com.zyq.movehome.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
;
import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/3/20 - 23:37
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    ApplyMapper applyMapper;
    @Autowired
    UserserviceMapper userserviceMapper;
    @Override
    public MsgResult<Boolean> insert(ApplyDTO applyDTO) {
     UserserviceDTO userserviceDTO = new UserserviceDTO();
     userserviceDTO.setUname(applyDTO.getUname());
        List<UserserviceDTO> list = userserviceMapper.selectUserservice(userserviceDTO);
        UserserviceDTO userserviceDTO1 = list.get(0);

        if(!userserviceDTO1.getCode().equals("0")){
            return MsgResult.fail(HomeEnum.SystemCode.HAVETEAM.getCode(),HomeEnum.SystemCode.HAVETEAM.message);
        }
        if(applyDTO.getType().equals(HomeEnums.applytype.SHENGQING.getCode())){

            List<ApplyDTO> applyDTOS = applyMapper.selectByUnameOrTname(applyDTO);
            if(!CollectionUtils.isEmpty(applyDTOS)){
                return MsgResult.fail("1","已经发送申请！请勿重复操作！");
            }

            StringBuffer s = new StringBuffer();
            s.append(applyDTO.getUname());
            s.append(HomeEnums.apply.SHENGQING.getMessage());
            applyDTO.setConnent(s.toString());

        }
        if(applyDTO.getType().equals(HomeEnums.applytype.YAOQING.getCode())){
            List<ApplyDTO> applyDTOS = applyMapper.selectByUnameOrTname(applyDTO);
            if(!CollectionUtils.isEmpty(applyDTOS)){
                return MsgResult.fail("0","已经发送邀请！请勿重复操作！");
            }

            StringBuffer s = new StringBuffer();
            s.append(applyDTO.getTname());
            s.append(HomeEnums.apply.YAOQING.getMessage());
            applyDTO.setConnent(s.toString());
        }
        applyDTO.setStatus("1");
        applyDTO.setApplytime(new Date());
        applyMapper.insertSelective(applyDTO);
        return MsgResult.success(true);
    }

    @Override
    public MsgResult<Boolean> update(ApplyDTO applyDTO) {

        if(applyDTO.getStatus().equals("2")){
            applyDTO.setStatus("2");
            applyMapper.updateByPrimaryKey(applyDTO);
            //调用方法添加团队信息；

            return MsgResult.success(true);
        }
        else if(applyDTO.getStatus().equals("3")){
            applyDTO.setStatus("3");
            applyMapper.updateByPrimaryKey(applyDTO);
            return MsgResult.success(true);
        }
      return MsgResult.fail("400","操作失败");
    }

    @Override
    public MsgResult<PageInfo<List<ApplyDTO>>> selectByname(ApplyDTO applyDTO) {
        PageHelper.startPage(1,4);
        List<ApplyDTO> applyDTOS = applyMapper.selectByUnameOrTname(applyDTO);
        PageInfo<List<ApplyDTO>> pageInfo = new PageInfo(applyDTOS,5);

        return MsgResult.success(pageInfo);
    }

    @Override
    public MsgResult<Boolean> delect(ApplyDTO applyDTO) {
        applyMapper.deleteByPrimaryKey(applyDTO.getApplyid());
        return MsgResult.success(true);
    }
}
