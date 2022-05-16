package com.anshun.mtasweb.controller;

import com.anshun.mtasweb.entity.CoreMenuEntity;
import com.anshun.mtasweb.service.CoreMenuService;
import com.anshun.mtasweb.vo.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mtasflash Created on 2022-04-29 15:15
 */
@Controller
@RequestMapping
public class IndexController {
    @Resource
    private CoreMenuService coreMenuService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("title", "hello,this is robert web");
        return modelAndView;
    }

    @RequestMapping(value = "/index.html", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("title", "hello,this is robert web");
        return modelAndView;
    }

    /**
     * 进入后台首页面
     */
    @RequestMapping(value = "home.html", method = {RequestMethod.GET})
    public ModelAndView home() {
        return new ModelAndView("home.html");
    }

    /**
     * 获取用户菜单数据
     */
    @RequestMapping(value = "getMenus.json", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg getMenus() {
        List<CoreMenuEntity> coreMenus = coreMenuService.getMenus();
        ResultMsg result = new ResultMsg();
        result.setData(coreMenus);
        return result;
    }

    /**
     * 进入403未授权页面
     */
    @RequestMapping(value = "403.html", method = {RequestMethod.GET})
    public ModelAndView error403() {
        return new ModelAndView("403.html");
    }

    /**
     * 进入404未定义页面
     */
    @RequestMapping(value = "404.html", method = {RequestMethod.GET})
    public ModelAndView error404() {
        return new ModelAndView("404.html");
    }
}
