package com.zds.controller;

import com.zds.bean.Custom;
import com.zds.service.CustomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/18
 * create_time : 22:42
 */
@Controller
public class CustomController {
    private Logger log = LoggerFactory.getLogger(CustomController.class);

    @Autowired
    CustomService customService;
    @RequestMapping("/getAllcustoms.action")
    @ResponseBody
    public List<Custom> getAllcustoms(){

        return customService.getAllcustoms();
    }

    @RequestMapping("/error.action")
    public String error(){
        return "error";
    }

    @RequestMapping("/toLogin.action")
    public String toLogin(){
        return "user_login";
    }

    @RequestMapping("/toRegister.action")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/toMain.action")
    public String toMain(){
        return "main";
    }

    @RequestMapping(value = "/loginCheck.action",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> loginCheck(Custom custom, HttpSession session){
        Map<String,String> map = new HashMap<String, String>();
        List<Custom> customs = customService.loginCheck(custom);
        System.out.println(custom.getCustName());
        System.out.println(custom.getCustPwd());
        session.removeAttribute("session");
        //session.invalidate();
        session.setAttribute("session",custom.getCustName());
        if (customs.isEmpty()){
            map.put("msg","error");
        }else {
            map.put("msg","ok");
        }
        return map;
    }
    @RequestMapping("/customRegister.action")
    public String customRegister(Custom custom){
        System.out.println(custom.getCustAddress());
        int row = customService.insert(custom);
        if (row>0){
            return "register_ok";
        }else{

            return "error";
        }
    }
    @RequestMapping("/toMyinfo.action")
    public String toMyinfo(){
        return "custom";
    }
    @RequestMapping("/myInfo.action")
    @ResponseBody
    public Custom myInfo(HttpSession session){
        return customService.selectByName((String)session.getAttribute("session"));
    }
    @RequestMapping("/toExit.action")
    public String toExit(HttpSession session){
        //session.invalidate();
        //session.removeAttribute("session");
        return "user_login";
    }
    @RequestMapping("/modifyCustom.action")
    @ResponseBody
    public Map<String,String> modifyCustom(String customs){
        Map<String,String> map = new HashMap<String, String>();
        int row = customService.modifyCustom(customs);
        if (row>0){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }
    ///
    @RequestMapping("/checkName.action")
    @ResponseBody
    public Map<String,String> checkName(String custName){
        Map<String,String> map = new HashMap<String, String>();
        Custom row = customService.selectByName(custName);
        if (row!=null){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }
    @RequestMapping("/searchCustom.action")
    @ResponseBody
    public List<Custom> searchCustom(String custName){
        Custom custom = customService.selectByName(custName);
        List<Custom> customs = new ArrayList<>();
        customs.add(custom);
        return customs;
    }
    @RequestMapping("/toWarn.action")
    public String toWarn(){
        return "warn";
    }
}
