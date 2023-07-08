package com.godin.locationSpring.handler;

import com.alibaba.fastjson.JSON;
import com.godin.locationSpring.model.Utilisateur;
import com.godin.locationSpring.service.TokenService;
import com.godin.locationSpring.service.UtilisateurService;
import com.godin.locationSpring.util.UtilisateurThreadLocal;
import com.godin.locationSpring.vo.ErrorCode;
import com.godin.locationSpring.vo.Result;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j 
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token = request.getHeader("Authorization");
//
//        log.info("============request start=============");
//        String requestURI = request.getRequestURI();
//        log.info("request uri:{}", requestURI);
//        log.info("request method:{}", request.getMethod());
//        log.info("token:{}", token);
//        log.info("============request end=============");

        if (StringUtils.isBlank(token)) {
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), ErrorCode.NO_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }

        Integer userId = tokenService.checkToken(token);
        Utilisateur utilisateur = utilisateurService.findById(userId);
        if (utilisateur == null) {
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), ErrorCode.NO_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }

        UtilisateurThreadLocal.put(utilisateur);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UtilisateurThreadLocal.remove();
    }
}
