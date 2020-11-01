package com.zyq.movehome.controller;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.ApplyDTO;
import com.zyq.movehome.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/3/20 - 23:47
 */
@RestController
public class ApplyController {
    @Autowired
    ApplyService applyService;

    @RequestMapping("/apply/add")
    public MsgResult<Boolean> add(@RequestBody ApplyDTO applyDTO){

        return applyService.insert(applyDTO);

    }

    @RequestMapping("/apply/edit")
    public MsgResult<Boolean> update(@RequestBody ApplyDTO applyDTO) {

        return applyService.update(applyDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/apply/select" ,method = RequestMethod.POST)
    public MsgResult<PageInfo<List<ApplyDTO>>> selectByname(@RequestBody ApplyDTO applyDTO) {
         return applyService.selectByname(applyDTO);
    }


    @ResponseBody
    @RequestMapping(value = "/apply/delect" ,method = RequestMethod.POST)
    public MsgResult<Boolean> delect(@RequestBody ApplyDTO applyDTO) {
        return applyService.delect(applyDTO);
    }
}
