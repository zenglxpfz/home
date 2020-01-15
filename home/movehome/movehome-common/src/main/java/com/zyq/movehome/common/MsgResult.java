package com.zyq.movehome.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/1/15 - 10:20
 */
@Data
public class MsgResult {

    private String message;
    private String code;
    private Map<String,Object> map = new HashMap<>();

    public MsgResult success(){
        MsgResult result = new MsgResult();
        result.setCode("200");
        result.setMessage("处理成功!");
        return result;

    }

    public MsgResult fail(){
        MsgResult result = new MsgResult();
        result.setCode("400");
        result.setMessage("处理失败!");
        return result;

    }

    public MsgResult add(String key,Object object){
        this.getMap().put(key,object);
        return  this;
    }

}
