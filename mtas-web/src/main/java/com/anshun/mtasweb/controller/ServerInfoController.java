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

    @RequestMapping(value = "index.html", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("module/server/serverInfo/index");
        modelAndView.addObject("title", "hello,this is serverInfo");
        return modelAndView;
    }

    @RequestMapping(value = "getInfo.json", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg getInfo() {
        List<ServerInfoEntity> serverInfo = serverInfoService.getAllData();
        PageInfo<ServerInfoEntity> pageInfo = new PageInfo<>(serverInfo);
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setData(pageInfo);
        return resultMsg;
    }

    /**
     * 进入新增页面
     */

    @RequestMapping(value = "add.html", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add() {
        return new ModelAndView("module/server/serverInfo/add");
    }

    /**
     * 添加操作
     */

    @RequestMapping(value = "add.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg add(ServerInfoEntity request) {
        serverInfoService.addData(request);
        return new ResultMsg();
    }

    /**
     * 编辑操作
     */

    @RequestMapping(value = "edit.html", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ModelAndView edit() {
        return new ModelAndView("module/server/serverInfo/edit");
    }

    /**
     * 编辑操作
     */

    @RequestMapping(value = "edit.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg update(ServerInfoEntity request) {
        serverInfoService.updateData(request);
        return new ResultMsg();
    }

    /**
     * 删除操作
     */

    @RequestMapping(value = "delete.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg delete(ServerInfoEntity request) {
        serverInfoService.deleteData(request.getId());
        return new ResultMsg();
    }
}
