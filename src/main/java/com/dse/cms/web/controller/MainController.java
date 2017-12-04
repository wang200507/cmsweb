package com.dse.cms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/12/3.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "menu";
    }
}
