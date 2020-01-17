package com.zyq.movehome.common;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/1/16 - 19:00
 */
public enum  HomeEnum {

        ABLE,
       enable;

        private String code;
        private String message;

//        private Status(String code,String message){
//            this.code = code;
//            this.message = message;
//        }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}
