package com.zyq.movehome.controller;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.HomeEnum;
import com.zyq.movehome.common.HomeEnums;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.*;
import com.zyq.movehome.mapper.*;
import com.zyq.movehome.service.TeamService;
import com.zyq.movehome.util.AppException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import java.io.File;
import java.util.*;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:47
 */
@Controller
@Api(value = "团队管理接口")
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;
    @Autowired
    UserserviceMapper userserviceMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    TeamMapper teamMapper;

    @Autowired
    ResoucesMapper resoucesMapper;
    @Autowired
    ContentMapper contentMapper;

    @Autowired
    ApplyMapper applyMapper;

    @Autowired
    OrderMapper orderMapper;

    @ResponseBody
    @ApiOperation(value = "创建团队接口", notes = "新建团队")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public MsgResult<Boolean> create(@RequestBody TeamNewDTO teamNewDTO, MultipartFile file, HttpSession session, HttpServletRequest req) {

        //try {创建一个新的文件在这里
//            if (file != null) {
//                File f = new File("");
//                //设置真实路径保存文件
//                String newname = file.getOriginalFilename();
//                String realpath = f.getAbsolutePath() + "/src/main/resources/static/images/";
//
//                // String realPath = f.getAbsolutePath() + "/home/movehome/movehome-web/src/java/resources/"
//                File f2 = new File(realpath + newname);
//                file.transferTo(f2);
//                String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/images/" + newname;
//
//               teamNewDTO.setTpicture(filePath);

            UserserviceDTO userserviceDTO = (UserserviceDTO) session.getAttribute("userservice");
            session.setMaxInactiveInterval(80 * 60);
            //查询数据库团队是否已经存在
            TeamDTO teamDTO = new TeamDTO();
            //teamDTO.setCode(teamNewDTO.getCode());
            teamDTO.setTname(teamNewDTO.getTname());
            List<TeamDTO> list = teamMapper.selectAll(teamDTO);
            if (list != null && list.size() > 0) {
                return MsgResult.fail(HomeEnum.SystemCode.EXIST_TEAM.code, HomeEnum.SystemCode.EXIST_TEAM.message);

            }
            UserserviceDTO userserviceDTO2 = userserviceMapper.selectByPrimaryKey(userserviceDTO.getUid());
            if (userserviceDTO2.getCode().equals('0')) {
                return MsgResult.fail(HomeEnum.SystemCode.EXIST_USERTEAM.code, HomeEnum.SystemCode.EXIST_USERTEAM.message);
            }
            TeamDTO teamDTO1 = new TeamDTO();
            teamDTO1.setCode(teamNewDTO.getCode());
            //teamDTO1.setTname(teamNewDTO.getTname());
            List<TeamDTO> list1 = teamMapper.selectAll(teamDTO1);
            if (list1 != null && list1.size() > 0) {
                return MsgResult.fail(HomeEnum.SystemCode.EXIST_TEAM.code, HomeEnum.SystemCode.EXIST_TEAM.message);

            }

            teamNewDTO.setStatus(HomeEnums.Status.YES.getCode());
            teamNewDTO.setCreatetime(new Date());
            try {
                int i = 0;
                long l = (int) i;
                //通过封装类Integer的方法longValue()将int转换为long类型；
                Integer b = 1;
                long longValue = b.longValue();
                teamNewDTO.setTperson(longValue);
                teamNewDTO.setTwatch(l);
                teamNewDTO.setTlikes(l);
                teamService.createTeam(teamNewDTO);
                //将用户信息的团队信息填充完整
                UserserviceDTO userserviceDTO1 = new UserserviceDTO();
                userserviceDTO1.setUid(teamNewDTO.getUid());
                userserviceDTO1.setRole("队长");
                userserviceDTO1.setCode(teamNewDTO.getCode());
                userserviceMapper.updateByPrimaryKeySelective(userserviceDTO1);

                //查询出团队信息和用户信息，再保存一次在session里面。
                UserserviceDTO userserviceDTO3 = new UserserviceDTO();
                userserviceDTO3 = userserviceMapper.selectByPrimaryKey(userserviceDTO.getUid());
                session.setAttribute("userservice", userserviceDTO3);
                session.setMaxInactiveInterval(80 * 60);
                TeamDTO teamDTO2 = new TeamDTO();
                teamDTO2.setCode(teamNewDTO.getCode());
                TeamDTO teamDTO3 = teamMapper.selectByCode(teamDTO2);
                session.setAttribute("team", teamDTO3);
                session.setMaxInactiveInterval(80 * 60);
                //   MsgResult<TeamNewDTO> teamNewDTOMsgResult = teamService.createTeam(teamNewDTO,userserviceDTO);
                //
                return MsgResult.success(true);

            } catch (Exception e) {
                throw new AppException(HomeEnum.SystemCode.ERROR_CREATETEAM.message);
            }

    }

    //点击同意时的逻辑
    @ResponseBody
    @ApiOperation(value = "t添加成员接口", notes = "添加成员接口")
    @RequestMapping(value = "/addchengyuan", method = RequestMethod.POST)
    public MsgResult<Boolean> addchengyuan(@RequestBody ApplyDTO a, HttpSession session) {
        //查询该用户的团队码是否已经存在

        UserserviceDTO userserviceDTO2 = new UserserviceDTO();
        userserviceDTO2.setUname(a.getUname());
        List<UserserviceDTO> list = userserviceMapper.selectUserservice(userserviceDTO2);
        UserserviceDTO user = list.get(0);
        if (!user.getCode().equals("0")) {
            return MsgResult.fail(HomeEnum.SystemCode.HAVETEAM.code, HomeEnum.SystemCode.HAVETEAM.code);
        }

        //根据团队名查询团队信息
        TeamDTO t = new TeamDTO();
        t.setTname(a.getTname());
        TeamDTO teamDTO = teamService.selectTeam(t);
        Long i = (teamDTO.getTperson());
        i++;
        teamDTO.setTperson(i);
        teamMapper.updateByPrimaryKeySelective(teamDTO);
        TeamDTO teamDTO1 = teamService.selectTeam(t);
        session.setAttribute("team", teamDTO1);
        UserserviceDTO u = new UserserviceDTO();
        u.setUname(a.getUname());
        List<UserserviceDTO> userserviceDTO1 = userserviceMapper.selectUserservice(u);
        UserserviceDTO userserviceDTO = userserviceDTO1.get(0);

        userserviceDTO.setRole("队员");
        userserviceDTO.setCode(teamDTO.getCode());
        userserviceMapper.updateByPrimaryKeySelective(userserviceDTO);
        a.setStatus("0");
        applyMapper.updateByPrimaryKey(a);
        //查询用户信息
        List<UserserviceDTO> userserviceDTOS = userserviceMapper.selectUserservice(u);
        UserserviceDTO userserviceDTO3 = userserviceDTOS.get(0);
       session.setAttribute("userservice",userserviceDTO3);
        session.setMaxInactiveInterval(80 * 60);
        return MsgResult.success(true);
    }

    @ResponseBody
    @ApiOperation(value = "查看成员接口", notes = "查询成员接口")
    @RequestMapping(value = "/selectchengyuan", method = RequestMethod.GET)
    public MsgResult<List<UserserviceDTO>> selectchengyuan(HttpSession session) {
        //拿到登录的人的信息，
        UserserviceDTO userservice = (UserserviceDTO) session.getAttribute("userservice");
        UserserviceDTO userserviceDTO1 = userserviceMapper.selectByPrimaryKey(userservice.getUid());
        UserserviceDTO userserviceDTO = new UserserviceDTO();
        //根据团队码查询到同一团队的人员信息。
        userserviceDTO.setCode(userserviceDTO1.getCode());
        List<UserserviceDTO> list = userserviceMapper.selectUserservice(userserviceDTO);
        session.setMaxInactiveInterval(80*60);
        return MsgResult.success(list);
    }

    @ResponseBody
    @ApiOperation(value = "查看团队信息接口", notes = "查询团队信息接口")
    @RequestMapping(value = "/selectTeam", method = RequestMethod.GET)
    public MsgResult<TeamDTO> selectTeam(HttpSession session) {
        //拿到登录的人的信息，
        UserserviceDTO userservice = (UserserviceDTO) session.getAttribute("userservice");
        TeamDTO teamDTO = new TeamDTO();
        if (userservice.getCode() == null || userservice.getCode().equals('0')) {
            UserserviceDTO userserviceDTO1 = userserviceMapper.selectByPrimaryKey(userservice.getUid());

            //根据团队码查询到同一团队的人员信息。
            teamDTO.setCode(userserviceDTO1.getCode());

            TeamDTO teamDTO1 = teamService.selectTeam(teamDTO);
            return MsgResult.success(teamDTO1);
        } else {
            teamDTO.setCode(userservice.getCode());
            TeamDTO teamDTO1 = teamService.selectTeam(teamDTO);
            //在查询一次团队信息时，存一次团的信息到session里面。根据team+团队id作为名字查询出团队信息
            session.setAttribute("team", teamDTO1);
            session.setMaxInactiveInterval(80*60);
            return MsgResult.success(teamDTO1);
        }
    }

    @ResponseBody
    @ApiOperation(value = "分页查询所有团队信息列表接口", notes = "查询团队信息接口")
    @RequestMapping(value = "/pageall", method = RequestMethod.GET)
    public MsgResult<PageInfo<List<TeamDTO>>> selectTeamlist(@PathParam("pn") Integer pn) {
        return teamService.selectTeamlist(pn);
    }

    @ResponseBody
    @ApiOperation(value = "查询最多订单团队信息列表接口", notes = "查询多订单团队信息接口")
    @RequestMapping(value = "/selectTop", method = RequestMethod.GET)
    public MsgResult<List<TeamDTO>> selectTop() {
        return teamService.selectTop(null);
    }

    @ResponseBody
    @ApiOperation(value = "查询最新订单团队信息列表接口", notes = "查询最新3团队信息接口")
    @RequestMapping(value = "/selectNew", method = RequestMethod.GET)
    public MsgResult<List<TeamDTO>> selectnew() {
        return teamService.selectNew(null);
    }

    @ResponseBody
    @ApiOperation(value = "点赞接口", notes = "点赞接口")
    @RequestMapping(value = "/addlikes/{tid}", method = RequestMethod.GET)
    public MsgResult<Boolean> addlikes(@PathVariable("tid") Integer tid) {
        return teamService.updateLikes(tid);
    }

    @ResponseBody
    @ApiOperation(value = "查看别人团队接口", notes = "查询团队信息接口")
    @RequestMapping(value = "/orderteam", method = RequestMethod.GET)
    public MsgResult<TeamDTO> selectorderTeam(@PathParam("tid") Integer tid, @PathParam("uid") Integer uid, HttpSession session) {
        if (uid != 0) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUid(uid);
            //查询出个人信息、
            UserDTO userDTO1 = userMapper.selectByPrimaryKey(uid);
            session.setAttribute("user", userDTO1);
        }//查询出团队信息
        UserserviceDTO userservice = new UserserviceDTO();
        TeamDTO teamDTO2 = teamService.selectOrderteam(tid);
        userservice.setCode(teamDTO2.getCode());
        //查出订单量。
        Integer i = 0;
        i = orderMapper.selectcount(teamDTO2.getTname());
        teamDTO2.setOrders(i);
        TeamDTO teamDTO = new TeamDTO();
//
        List<UserserviceDTO> list = userserviceMapper.selectUserservice(userservice);
        ResoucesDTO resoucesDTO = new ResoucesDTO();
        resoucesDTO.setTid(tid);
        List<ResoucesDTO> list1 = resoucesMapper.selectList(resoucesDTO);

        teamDTO2.setResoucesDTOS(list1);

        List<ContentDTO> list2 = contentMapper.selectByTid(tid);
        teamDTO2.setContentDTOS(list2);
        teamDTO2.setUserserviceDTOs(list);
        session.setAttribute("team",teamDTO2);
        session.setMaxInactiveInterval(80*60);
        return MsgResult.success(teamDTO2);
    }

    @ResponseBody
    @ApiOperation(value = "查看别人团队接口", notes = "查询团队信息接口")
    @RequestMapping(value = "/orderteamss", method = RequestMethod.GET)
    public MsgResult<TeamDTO> selectorderTeam2(@PathParam("tid") Integer tid, @PathParam("uid") Integer uid, HttpSession session) {
        if (uid != 0) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUid(uid);
            //查询出个人信息、
            UserDTO userDTO1 = userMapper.selectByPrimaryKey(uid);
            session.setAttribute("user", userDTO1);
        }//查询出团队信息
        UserserviceDTO userservice = new UserserviceDTO();
        TeamDTO teamDTO2 = teamService.selectOrderteam(tid);
        userservice.setCode(teamDTO2.getCode());
        //查出订单量。
        Integer i = 0;
        i = orderMapper.selectcount(teamDTO2.getTname());
        teamDTO2.setOrders(i);
        TeamDTO teamDTO = new TeamDTO();
//
        List<UserserviceDTO> list = userserviceMapper.selectUserservice(userservice);
        ResoucesDTO resoucesDTO = new ResoucesDTO();
        resoucesDTO.setTid(tid);
        List<ResoucesDTO> list1 = resoucesMapper.selectList(resoucesDTO);

        teamDTO2.setResoucesDTOS(list1);

        List<ContentDTO> list2 = contentMapper.selectByTid(tid);
        teamDTO2.setContentDTOS(list2);
        teamDTO2.setUserserviceDTOs(list);
       // session.setAttribute("team",teamDTO2);
        session.setMaxInactiveInterval(80*60);
        return MsgResult.success(teamDTO2);
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(value = "删除团队接口", notes = "")
    public MsgResult<Boolean> delect(@RequestBody TeamDTO teamDTO) {

        return teamService.delect(teamDTO);
    }

    @ResponseBody
    @ApiOperation(value = "查看别人团队接口", notes = "查询团队信息接口")
    @RequestMapping(value = "/orderteams", method = RequestMethod.GET)
    public MsgResult<TeamDTO> selectorderTeams(@PathParam("tid") Integer tid, @PathParam("uid") Integer uid, HttpSession session) {
        if (uid != 0) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUid(uid);
            //查询出个人信息、
            UserDTO userDTO1 = userMapper.selectByPrimaryKey(uid);
            session.setAttribute("user", userDTO1);
            session.setMaxInactiveInterval(80*60);
        }//查询出团队信息
        UserserviceDTO userservice = new UserserviceDTO();
        TeamDTO teamDTO2 = teamService.selectOrderteam(tid);
        userservice.setCode(teamDTO2.getCode());
        //查出订单量。
        Integer i = 0;
        i = orderMapper.selectcount(teamDTO2.getTname());
        if (i == null) {
            teamDTO2.setOrders(0);
        } else {
            teamDTO2.setOrders(i);
        }

        TeamDTO teamDTO = new TeamDTO();
//
        List<UserserviceDTO> list = userserviceMapper.selectUserservice(userservice);
        ResoucesDTO resoucesDTO = new ResoucesDTO();
        resoucesDTO.setTid(tid);
        List<ResoucesDTO> list1 = resoucesMapper.selectList(resoucesDTO);

        teamDTO2.setResoucesDTOS(list1);

        List<ContentDTO> list2 = contentMapper.selectByTid(tid);
        teamDTO2.setContentDTOS(list2);
        teamDTO2.setUserserviceDTOs(list);
        session.setAttribute("team", teamDTO2);
        session.setMaxInactiveInterval(80*60);
        return MsgResult.success(teamDTO2);
    }

    @ResponseBody
    @RequestMapping(value = "/selectByCode", method = RequestMethod.POST)
    @ApiOperation(value = "根据登录人的团队码查询接口", notes = "")
    public MsgResult<TeamDTO> selectBycode(@RequestBody TeamDTO teamDTO) {

        return teamService.selectbycode(teamDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/delchengyuan", method = RequestMethod.GET)
    @ApiOperation(value = "删除成员接口", notes = "")
    public MsgResult<Boolean> delectchengyuan(@PathParam("tid") Integer tid, @PathParam("uid") Integer uid) {

        return teamService.delectchengyuan(tid, uid);
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "修改团队信息接口", notes = "")
    public MsgResult<Boolean> edit(@RequestBody TeamDTO teamDTO) {

        return teamService.edit(teamDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/selectbykey", method = RequestMethod.POST)
    @ApiOperation(value = "查询列表团队信息接口", notes = "")
    public MsgResult<PageInfo<List<TeamDTO>>> edit(@RequestBody SouDTO souDTO) {

        return teamService.selectbykey(souDTO);
    }

}



