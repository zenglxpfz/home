package com.zyq.movehome.util;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 9:52
 */
public class AppException extends RuntimeException {

    private final String errorCode;


    public AppException(String code){
        super(code);
        this.errorCode = code;

    }

    public String getErrorCode() {
        return errorCode;
    }

}
