package com.anshun.mtasweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mtasflash Created on 2022-04-29 15:15
 */
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("title", "hello,this is robert web");
        return modelAndView;
    }
}
