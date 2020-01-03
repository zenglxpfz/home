package com.zyq.movehome.serviceImpl;


import com.zyq.movehome.dto.TestGetDTO;
import com.zyq.movehome.mapper.TestMapper;
import com.zyq.movehome.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2019/12/30 - 17:52
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;
    @Override
    public List<TestGetDTO> get() {
        return testMapper.get();
    }
}
