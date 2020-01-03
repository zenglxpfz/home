package com.zyq.movehome.mapper;

import com.zyq.movehome.dto.TestGetDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2019/12/30 - 22:56
 */
@Mapper
public interface TestMapper {

   public List<TestGetDTO> get();
}
