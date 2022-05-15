package com.anshun.mtasweb.controller;

import com.anshun.mtasweb.entity.ServerInfoEntity;
import com.anshun.mtasweb.service.ServerInfoService;
import com.anshun.mtasweb.vo.ResultMsg;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mtasflash Created on 2022-05-06 14:54
 */
@Controller
@RequestMapping("serverInfo")
public class ServerInfoController {

    @Resource
    private ServerInfoService serverInfoService;

    @RequestMapping(value = "index", method = {RequestMethod.GET})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("module/server/serverInfo/index.html");
        modelAndView.addObject("title", "hello,this is serverInfo");
        return modelAndView;
    }

    @RequestMapping(value = "getInfo.json", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg getInfo() {
        List<ServerInfoEntity> serverInfo = serverInfoService.getServerInfo();
        serverInfo.add(serverInfo.get(0));
        serverInfo.add(serverInfo.get(0));
        serverInfo.add(serverInfo.get(0));
        serverInfo.add(serverInfo.get(0));
        PageInfo<ServerInfoEntity> pageInfo = new PageInfo<>(serverInfo);
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setData(pageInfo);
        return resultMsg;
    }
}
