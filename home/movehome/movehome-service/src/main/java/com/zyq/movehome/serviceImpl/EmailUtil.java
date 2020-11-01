package com.zyq.movehome.serviceImpl;

//import org.apache.commons.mail4.EmailException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 发送邮箱的工具类
 */
public class EmailUtil {
    public Boolean sendEamilCode(String email,String title,String msg) {
        HtmlEmail send = new HtmlEmail();
        try {
            send.setHostName("smtp.qq.com");
            send.setSmtpPort(465); //端口号
            send.setSSLOnConnect(true); //开启SSL加密
            send.setCharset("utf-8");
            send.addTo(email); //接收者的QQEamil
            send.setFrom("1306096654@qq.com", "同城搬家供需信息交流平台");  //第一个参数是发送者的QQEamil   第二个参数是发送者QQ昵称
            send.setAuthentication("1306096654@qq.com", "glhyiquhjeuijaah"); //第一个参数是发送者的QQEamil   第二个参数是刚刚获取的授权码
            send.setSubject(title);//Eamil的标题
            send.setMsg(msg);  //Eamil的内容
            send.send(); //发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return true;
    }

}
