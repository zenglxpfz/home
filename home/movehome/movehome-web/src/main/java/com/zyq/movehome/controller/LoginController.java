package com.zyq.movehome.controller;

import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.HomeEnums;

import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.AdminMapper;
import com.zyq.movehome.mapper.TeamMapper;
import com.zyq.movehome.service.UserService;
import com.zyq.movehome.service.UserserviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/27 - 14:34
 */
@Api(value = "登录")
@Controller
public class LoginController {

    @Autowired
    UserserviceService userserviceService;

    @Autowired
    UserService userService;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    TeamMapper teamMapper;


    @ApiOperation(value = "登录")
    @RequestMapping(value = "/logins",method = RequestMethod.POST)
    public String login(LoginDTO loginDTO, HttpSession session) {

        //如果是提供服务查询用户服务表
        if (loginDTO.getType().equals(HomeEnums.Role.SERVICE.getCode())) {
            session.setAttribute("loginerror", null);
            UserserviceDTO userserviceDTO1 = new UserserviceDTO();
            userserviceDTO1.setUname(loginDTO.getUname());
            userserviceDTO1.setPassword(loginDTO.getPassword());
            UserserviceDTO userserviceDTO = userserviceService.selectUserserviceBynameAndpassword(userserviceDTO1);
            if (userserviceDTO == null) {
                session.setAttribute("loginerror", "用户名或密码错误或选择类型错误");
                session.setMaxInactiveInterval(80*60);
               // return MsgResult.fail("error","用户名或密码错误或选择类型错误");
                return "/login.html";
            }
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setCode(userserviceDTO.getCode());
            TeamDTO teamDTO1 = teamMapper.selectByCode(teamDTO);
            if(teamDTO1!=null){
                session.setAttribute("team",teamDTO1);
            }
            session.setAttribute("userservice",userserviceDTO);
            session.setMaxInactiveInterval(80*60);
            //重定向
          //  return MsgResult.success("2",userserviceDTO);
            return "redirect:/userservice/main";
        }

        //如果是需要user服务查询用户服务表
if(loginDTO.getType().equals(HomeEnums.Role.SERVICEED.getCode())) {
    session.setAttribute("loginerror", null);
    UserDTO userDTO1 = new UserDTO();
    userDTO1.setUname(loginDTO.getUname());
    userDTO1.setPassword(loginDTO.getPassword());
    UserDTO userDTO = userService.selectUserBynameAndpassword(userDTO1);
    if (userDTO == null) {
        session.setAttribute("loginerror", "用户名或密码或选择类型错误!!");
      //  return MsgResult.fail("error","用户名或密码错误或选择类型错误");
        return "/login.html";

    }
    session.setAttribute("user", userDTO);
    session.setMaxInactiveInterval(80*60);
   // return   MsgResult.success("2",userDTO);
    return "redirect:/main";

}
      if(loginDTO.getType().equals(HomeEnums.Role.ADNIM.getCode())) {
          AdminDTO adminDTO = new AdminDTO();
          adminDTO.setAname(loginDTO.getUname());
          adminDTO.setPassword(loginDTO.getPassword());
          AdminDTO adminDTO1 = adminMapper.selectBynameAndpassword(adminDTO);
          if (adminDTO1 == null) {
              session.setAttribute("loginerror", "用户名或密码错误或选择类型错误");
              //
              // return MsgResult.fail("error","用户名或密码错误或选择类型错误");
              return "/login.html";

          }

          session.setAttribute("admin", adminDTO1);
          session.setMaxInactiveInterval(80*60);
          // return  MsgResult.success("1",adminDTO1);
          return "redirect:/admin/main";
      }
      return "/login.html";
    }

    @RequestMapping("b")
    public String a(){
        return "/login.html";
    }
    @RequestMapping("lo")
    public String af(){
        return "/user/user.html";
    }

    @RequestMapping("/userservice/main")
    public String userservice(){
        return "userservice/index.html";
    }



}
