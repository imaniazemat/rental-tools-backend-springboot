package com.godin.locationSpring.controller;

import com.godin.locationSpring.model.Utilisateur;
import com.godin.locationSpring.service.LoginService;
import com.godin.locationSpring.service.UtilisateurService;
import com.godin.locationSpring.util.JWTUtils;
import com.godin.locationSpring.vo.Result;
import com.godin.locationSpring.vo.params.LoginParam;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UtilisateurService utilisateurService;

/*    @PostMapping
    public Utilisateur loginTest(Utilisateur utilisateur) {
        try {
            Utilisateur utilisateurServiceById = utilisateurService.findUtilisateurByCourriel(utilisateur.getCourriel());
            if (utilisateurServiceById != null
                    && utilisateurServiceById.getCourriel().equals(utilisateur.getCourriel())
                    && utilisateurServiceById.getPassword().equals(utilisateur.getPassword())) {
                utilisateurServiceById.setToken(JWTUtils.createToken(utilisateurServiceById.getId()));

                return utilisateurServiceById;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    @PostMapping
    public Result login(@RequestBody LoginParam loginParam) {
        return loginService.login(loginParam);
    }

/*
    @GetMapping("/checkToken")
    public Result checkToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
//        "data": "{userId=1, iat=1671079432, exp=1671968465}"
        return Result.success(stringObjectMap.get("userId"));
    }
*/


   /* @PostMapping
    public Result login() {

        sessionStorage.setItem('key', 'value')
        sessionStorage.id = id
        sessionStorage.token = token

        sessionStorage.getItem('key')
        sessionStorage.token


        return loginService.login();
    }*/
}
