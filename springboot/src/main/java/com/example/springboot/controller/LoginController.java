package com.example.springboot.controller;

import com.example.springboot.constant.DConstant;
import com.example.springboot.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2020/7/31 22:28
 */
@Controller
@Validated
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    public CommonResponse login(@NotNull(message = "name不为空") String name) {
        CommonResponse response = new CommonResponse();
        return response;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse create(@Validated @RequestBody UserInfoVO userInfoVO) {
        CommonResponse response = new CommonResponse(DConstant.HttpConstant.HTTP_SUCCESS_200);

        logger.info("before call service.method.");

        // todo:业务逻辑代码实现

        logger.info("after call service.method.");

        logger.info(userInfoVO.toString());
        Map<String, String> map = new HashMap<>();

        map.put("view", "success");

        response.setData(map);

        return response;
    }

    /**
     * 成功页面跳转
     *
     * @return 成功页面view名称
     */
    @RequestMapping(value = "success", method = RequestMethod.GET)
    public String toSuccess() {
        return DConstant.VIEW.SUCCESS;
    }
}
