package com.zyq.movehome.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/1/15 - 10:20
 */
public class MsgResult<T> implements Serializable {

    private String message;
    private Boolean success;
    private String code;
    private Map<String,Object> result = new HashMap<>();
    //报存数据信息
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //如果MsgResult中的T是什么类型，然后 参数就传什么类型的数据到success里面，返回时可以这样写MsgResult<Blooen>.success(true）;
    //MsgResult<List<Test>>.success(TestList）
    public static <T> MsgResult<T> success(T data){
        MsgResult<T> result = new MsgResult();
        result.setCode("code");
        result.setSuccess(true);
        result.setData(data);
        return result;

    }

    public static <T> MsgResult<T> success(String code,T data){
        MsgResult<T> result = new MsgResult();
        result.setCode(code);
        result.setSuccess(true);
        result.setData(data);
        return result;

    }
    //返回失败时带数据
    public static <T> MsgResult<T> fail(String code,String message,T data){
        MsgResult<T> result = new MsgResult();
        result.setCode(code);
        result.setSuccess(false);
        result.setMessage(message);
        result.setData(data);
        return result;

    }
    public static <T> MsgResult<T> fail(String code,String message){
        MsgResult<T> result = new MsgResult();
        result.setCode(code);
        result.setSuccess(false);
        result.setMessage(message);
        result.setData(null);
        return result;

    }

    //添加多条数据时
    public  MsgResult add(String key,Object object){
        this.getResult().put(key,object);
        return  this;
    }

}
