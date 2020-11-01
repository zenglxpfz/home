package com.zyq.movehome.serviceImpl;

import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.HuifuplDTO;
import com.zyq.movehome.mapper.HuifuplMapper;
import com.zyq.movehome.service.HuifuplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/3/22 - 3:39
 */
@Service
public class HuifuplServiceImpl implements HuifuplService {

    @Autowired
    HuifuplMapper huifuplMapper;
    @Override
    public MsgResult<Boolean> insert(HuifuplDTO huifuplDTO) {
        huifuplMapper.insertSelective(huifuplDTO);
        return MsgResult.success(true);
    }

    @Override
    public MsgResult<List<HuifuplDTO>> select(HuifuplDTO huifuplDTO) {
        return null;
    }

    @Override
    public MsgResult<HuifuplDTO> selectBykey(Integer aid) {
        return null;
    }

    @Override
    public MsgResult<Boolean> delect(Integer aid) {
        huifuplMapper.deleteByPrimaryKey(aid);

        return MsgResult.success(true);
    }
}
