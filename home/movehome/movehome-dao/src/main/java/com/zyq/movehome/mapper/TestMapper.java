package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.TestGetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/1/14 - 19:14
 */
@Mapper
public interface TestMapper {
    //@Select("select * from dept")
    public List<TestGetDTO> get();

    public TestGetDTO selectone(Integer deptId);
}
