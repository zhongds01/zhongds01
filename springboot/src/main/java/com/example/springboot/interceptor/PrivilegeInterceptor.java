package com.example.springboot.interceptor;

import com.example.springboot.annotation.Privilege;
import com.example.springboot.service.PrivilegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 权限控制拦截器,并记录接口操作日志
 * Author: zhongds
 * Date : 2020/8/2 22:21
 */
@Component
public class PrivilegeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(PrivilegeInterceptor.class);

    private static PrivilegeService privilegeService = null;

    /**
     * 权限校验：1、当前请求的url（接口名称）2、用户信息3、权限名称
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        privilegeService = context.getBean(PrivilegeService.class);

        // 1、获取请求url/请求的接口名称
        StringBuffer requestURL = request.getRequestURL();
        logger.info("当前请求名称为：" + requestURL.toString());
        // 2、获取当前请求的用户信息
        String name = request.getParameter("name");
        logger.info("当前用户：" + name);

        return privilegeValidate(handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private boolean privilegeValidate(Object handler) {

        Privilege privilege = null;

        boolean result = true;

        if (handler instanceof HandlerMethod) {
            // 3、获取权限注解信息
            privilege = ((HandlerMethod) handler).getMethod().getAnnotation(Privilege.class);
            if (null != privilege) {
                // 获取权限信息，去业务层实现权限验证
                String privilegeValue = privilege.value();

                if (privilegeService.havingPrivilege("zds", "123123", privilegeValue)) {
                    logger.info("权限校验通过。。。");
                    result = true;
                } else {
                    logger.error("权限校验未通过。。。");
                    result = false;
                }
            }
        }

        return result;
    }
}
