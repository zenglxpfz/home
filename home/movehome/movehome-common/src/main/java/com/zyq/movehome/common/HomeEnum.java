package com.zyq.movehome.common;

import com.zyq.movehome.dto.MessageDTO;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/1/16 - 19:00
 */
@Systemcode
public class HomeEnum {
//系统状态码
   public enum SystemCode{
        System_ERROR("System001","系统发生错误"),
        NOT_NULL_NAME("System002","用户名不能为空"),
        EXIST_USER("System003","用户已存在，请重新注册！"),
        EXIST_TEAM("System004","团队名称或团队码已存在，请重新输入"),
    ERROR_CREATETEAM ("System005","团队创建失败"),
    ERROR_SELECT_RESOUCES("System006","查询资源失败"),
    EXIST_USERTEAM ("System007","你已经有团队啦，不必创建！") ,
    RELOGIN ("System008","请先登录！"),
    HAVETEAM("System009","你已经存在团队了！"),
    ;


    public String code;
        public String message;

         SystemCode(String code ,String message){
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }


        public String getMessage() {
            return message;
        }

     }



}
