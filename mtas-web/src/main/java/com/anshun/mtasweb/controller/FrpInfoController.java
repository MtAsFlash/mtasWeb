package com.anshun.mtasweb.controller;

import com.anshun.mtasweb.entity.FrpInfoEntity;
import com.anshun.mtasweb.service.FrpInfoService;
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
 * @author mtasflash Created on 2022-05-20 20:07
 * <p>
 * frp分配信息,记录分配出去的frp名称/端口/分配给的PC电脑
 */
@Controller
@RequestMapping("frpInfo")
public class FrpInfoController {
    @Resource
    private FrpInfoService frpInfoService;

    @RequestMapping(value = "index.html", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("module/frpInfo/index");
        modelAndView.addObject("title", "hello,this is serverInfo");
        return modelAndView;
    }

    @RequestMapping(value = "getInfo.json", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg getInfo() {
        List<FrpInfoEntity> serverInfo = frpInfoService.getAllData();
        PageInfo<FrpInfoEntity> pageInfo = new PageInfo<>(serverInfo);
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setData(pageInfo);
        return resultMsg;
    }

    /**
     * 进入新增页面
     */

    @RequestMapping(value = "add.html", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add() {
        return new ModelAndView("module/frpInfo/add");
    }

    /**
     * 添加操作
     */

    @RequestMapping(value = "add.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg add(FrpInfoEntity request) {
        frpInfoService.addData(request);
        return new ResultMsg();
    }

    /**
     * 编辑操作
     */

    @RequestMapping(value = "edit.html", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ModelAndView edit() {
        return new ModelAndView("module/frpInfo/edit");
    }

    /**
     * 编辑操作
     */

    @RequestMapping(value = "edit.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg update(FrpInfoEntity request) {
        frpInfoService.updateData(request);
        return new ResultMsg();
    }

    /**
     * 删除操作
     */

    @RequestMapping(value = "delete.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg delete(FrpInfoEntity request) {
        frpInfoService.deleteData(request.getId());
        return new ResultMsg();
    }
}
