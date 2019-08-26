package com.zhou.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    private static Logger logger = Logger.getLogger(HomeController.class);

    /**
     * 测试 spring 整合 thymeleaf
     * @param model 将信息添加到域中
     * @return home 视图
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello", "jjjj");
        logger.info("执行了hello方法……");
        return "home";
    }
}
