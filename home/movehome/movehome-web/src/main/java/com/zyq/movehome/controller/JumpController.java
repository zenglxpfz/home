package com.zyq.movehome.controller;

import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.TeamDTO;
import com.zyq.movehome.dto.UserserviceDTO;
import com.zyq.movehome.dto.UserserviceNewDTO;
import com.zyq.movehome.mapper.TeamMapper;
import com.zyq.movehome.mapper.UserMapper;
import com.zyq.movehome.mapper.UserserviceMapper;
import com.zyq.movehome.service.TeamService;
import com.zyq.movehome.service.UserserviceService;
import com.zyq.movehome.util.AppException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/27 - 11:46
 */
@Controller
@Api(value = "跳转层控制器")
public class JumpController {

    @Autowired
    UserserviceService userserviceService;
    @Autowired
    TeamService teamService;
    @Autowired
    UserserviceMapper userserviceMapper;


    @ResponseBody
    @RequestMapping(value = "/adduserservice",method = RequestMethod.POST)
    public MsgResult<Boolean> addUser(@RequestBody UserserviceNewDTO userserviceNewDTO,HttpServletRequest req, HttpSession session){
     session.setAttribute("mession",null);
       // try {
//            if(file.getOriginalFilename()!=null&&!file.getOriginalFilename().equals("")) {
//                File f = new File("");//创建新的空文件
//                //f.getAbsolutePath()项目路径到项目名
//                String realpath = f.getAbsolutePath() + "/home/movehome/movehome-web/src/main/resources/static/images/";
//
//                //设置文件名字
//                String newname = file.getOriginalFilename();
//                //创建新文件
//                File f2 = new File(realpath + newname);
//
//                file.transferTo(f2);
//                //文件路径
//
//                String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/images/" + newname;
//
//                userserviceNewDTO.setPicture(filePath);
//                //  return userserviceService.addUserservice(userserviceNewDTO);
//            }

            MsgResult<Boolean> booleanMsgResult = userserviceService.addUserservice(userserviceNewDTO);
            if(booleanMsgResult.getSuccess().equals("false")){
                session.setAttribute("message","用户已存在");
                return MsgResult.fail("036","用户已存在，请重新注册！");
               // return "/user/userservice.html";
            }
//            return "redirect:/";
            return MsgResult.success(true);
          // } catch (IOException e)
//        {
//               throw new AppException(HomeEnum.SystemCode.System_ERROR.code);
//           }

    }
    //主页面
    @RequestMapping("/main")
    public String login(HttpSession session){
//        session.setAttribute("userservice",null);
//        session.setAttribute("user",null);

        return "/user/index.html";
    }

    //后台管理主页面
    @RequestMapping("/admin/main")
    public String admin(HttpSession session){
//        session.setAttribute("userservice",null);
//        session.setAttribute("user",null);

        return "/admin/main.html";
    }
    //登录页面
    @RequestMapping("/")
    public String login1(HttpSession session){
    session.setAttribute("loginerror",null);

        return "login.html";
    }
    //需要服务页面
    @RequestMapping("/user/form")
    public String user(){
        return "user/user.html";
    }
    //提供服务页面
    @RequestMapping("/userservice/form")
    public String userservices(){
        return "user/userservice.html";
    }

    //退出登录
    @RequestMapping("/loginup")
    public String loginup(HttpSession session){
        session.setAttribute("user",null);
        session.setAttribute("admin",null);
        session.setAttribute("userservce",null);
        session.setAttribute("team",null);
        return "redirect:/";
    }

    //查询团队详情
    @ResponseBody
    @RequestMapping(value = "/team/message",method = RequestMethod.GET)
    public MsgResult<Boolean> getmessage(@PathParam("tid") Integer tid ,HttpSession session){
        session.setAttribute("tid",tid);
        session.setMaxInactiveInterval(80*60);
        return MsgResult.success(true).add("tid",tid);
    }

    //----------------------------用户通知----------------------------------
    //查询通知详情
    @ResponseBody
    @RequestMapping(value = "/notice/selectBybid",method = RequestMethod.GET)
    public MsgResult<Boolean> getnotice(@PathParam("bid") Integer bid ,HttpSession session){
        session.setAttribute("bid",bid);
        session.setMaxInactiveInterval(80*60);
        System.out.println(bid);
        return MsgResult.success(true).add("bid",bid);
    }
    @RequestMapping(value = "/u/notice",method = RequestMethod.GET)
    public String tonotice(){

        return "/user/notice.html";
    }
    //公告跳转
    @RequestMapping(value = "/notice" ,method = RequestMethod.GET)
    public String notice(){

        return "/user/typography.html";

    }
   //--------------------------------------------------------------

    //----------------------------团队通知----------------------------------
    //查询通知详情
    @ResponseBody
    @RequestMapping(value = "/team/notice/selectBybid",method = RequestMethod.GET)
    public MsgResult<Boolean> getnoticeforteam(@PathParam("bid") Integer bid ,HttpSession session){
        session.setAttribute("bid",bid);
        session.setMaxInactiveInterval(80*60);
        System.out.println(bid);
        return MsgResult.success(true).add("bid",bid);
    }
    @RequestMapping(value = "/team/notice",method = RequestMethod.GET)
    public String tonoticefotteam(){

        return "/userservice/notice.html";
    }
    //公告跳转
    @RequestMapping(value = "/forteam/notice" ,method = RequestMethod.GET)
    public String noticeforteam(){

        return "/userservice/typography.html";

    }
    //--------------------------------------------------------------

    //查询提供服务团队信息
    @ResponseBody
    @RequestMapping(value = "/team/messageuserservice",method = RequestMethod.GET)
    public MsgResult<Boolean> getmessage(@PathParam("tname") String tname ,HttpSession session){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTname(tname);
        TeamDTO teamDTO1 = teamService.selectTeam(teamDTO);

        session.setAttribute("tids",teamDTO1.getTid());
        session.setMaxInactiveInterval(80*60);
        return MsgResult.success(true).add("tids",teamDTO1.getTid());
    }

    //查询团队详情跳转myteammessage
    @RequestMapping(value = "/team/teammessage")
    public String team(){
        return "user/teammessage.html";
    }


//查询团队详情跳转2
    @RequestMapping(value = "/team/messageBytname",method = RequestMethod.GET)
    public String teamUserservcie(@PathParam("tid") Integer tid){

        return "/userservice/teammessage.html";
    }
    //查询订单跳转
    @RequestMapping(value = "/order" ,method = RequestMethod.GET)
    public String order(){
        return "user/about.html";
    }

    //用户查询留言跳转
    @RequestMapping(value = "/myliuyan" ,method = RequestMethod.GET)
    public String liuyan(){
        return "user/content.html";
    }

    //查询所有搬家团队跳转
    @RequestMapping(value = "/moveteam" ,method = RequestMethod.GET)
    public String moveteam(){
        return "user/services.html";
    }

    //下单跳转
    @RequestMapping(value = "/xiadan" ,method = RequestMethod.GET)
    public String xiadan(@PathParam("tname")String tname,@PathParam("uname")String uname){

        return "user/inputorder.html";
    }

    //错跳转
    @RequestMapping(value = "/error" ,method = RequestMethod.GET)
    public String error(){

        return "user/error.html";
    }

    //创建团队跳转
    @RequestMapping(value = "/create" ,method = RequestMethod.GET)
    public String create(){

//        UserserviceDTO userserviceDTO = new UserserviceDTO();
//        userserviceDTO.setUname(applyDTO.getUname());
//        List<UserserviceDTO> list = userserviceMapper.selectUserservice(userserviceDTO);
//        UserserviceDTO userserviceDTO1 = list.get(0);
//
//        if(!userserviceDTO1.getCode().equals("0")){
//            return MsgResult.fail(HomeEnum.SystemCode.HAVETEAM.getCode(),HomeEnum.SystemCode.HAVETEAM.message);
//        }
        return "userservice/createteam.html";
    }

    //创建团队跳转
    @RequestMapping(value = "/myteammessage" ,method = RequestMethod.GET)
    public String myteammessage(HttpSession session){
   UserserviceDTO userserviceDTO = (UserserviceDTO) session.getAttribute("userservice");
        MsgResult<UserserviceDTO> userserviceDTOMsgResult = userserviceService.selectOne(userserviceDTO.getUid());
        UserserviceDTO data = userserviceDTOMsgResult.getData();
        session.setAttribute("useservice",data);
        session.setMaxInactiveInterval(80*60);
        TeamDTO teamDTO = new TeamDTO();
        if (!data.getCode().equals('0')) {
            teamDTO.setCode(data.getCode());
            MsgResult<TeamDTO> selectbycode = teamService.selectbycode(teamDTO);
            TeamDTO teamDTO1 = selectbycode.getData();
            session.setAttribute("team",teamDTO1);
            session.setMaxInactiveInterval(80*60);
        }
        return "/userservice/myteammessage.html";
    }

    //订单跳转
    @RequestMapping(value = "/u/order" ,method = RequestMethod.GET)
    public String myteamorder(){

        return "/userservice/about.html";

    }
    //团队留言跳转
    @RequestMapping(value = "/u/myliuyan" ,method = RequestMethod.GET)
    public String myliuyan(){

        return "userservice/content.html";

    }

    //订单详情跳转
    @RequestMapping(value = "/order/pinglun" ,method = RequestMethod.GET)
    public String pinglun(){

        return "/user/orderpinglun.html";

    }


//订单详情跳转
    @RequestMapping(value = "/orderTeam/pinglun" ,method = RequestMethod.GET)
    public String pinglunteam(){

        return "/userservice/orderTeam.html";

    }


//订单详情跳转
    @RequestMapping(value = "/u/apply" ,method = RequestMethod.GET)
    public String apply(){

        return "/userservice/content.html";

    }

    //订单详情跳转
    @RequestMapping(value = "/u/contact" ,method = RequestMethod.GET)
    public String contact(){

        return "/userservice/contact.html";

    }

    //订单详情跳转
    @RequestMapping(value = "/a/notice" ,method = RequestMethod.GET)
    public String notices(){

        return "/admin/notice.html";
    }



}
