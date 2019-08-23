package com.zds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/19
 * create_time : 4:22
 */
@Controller
public class ManagerController {
    @RequestMapping("/toManager.action")
    public String toManager(){
        return "manager";
    }
}
