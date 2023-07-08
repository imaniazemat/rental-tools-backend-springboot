package com.godin.locationSpring.service.impl;


import com.godin.locationSpring.model.Administrateur;
import com.godin.locationSpring.model.Utilisateur;
import com.godin.locationSpring.service.AdministrateurService;
import com.godin.locationSpring.service.LoginService;
import com.godin.locationSpring.service.UtilisateurService;
import com.godin.locationSpring.util.JWTUtils;
import com.godin.locationSpring.vo.ErrorCode;
import com.godin.locationSpring.vo.Result;
import com.godin.locationSpring.vo.Role;
import com.godin.locationSpring.vo.params.LoginParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private AdministrateurService administrateurService;


    @Override
    public Result login(LoginParam loginParam) {
        String courriel = loginParam.getCourriel();
        String password = loginParam.getPassword();
        String role;
        String token;
        if (StringUtils.isBlank(courriel) || StringUtils.isBlank(password)) {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        Utilisateur utilisateur = utilisateurService.findUtilisateurByCourrielAndPassword(courriel, password);
        if (utilisateur == null) {
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }

        Boolean administrateurExist = administrateurService.existsById(utilisateur.getId());
        if (administrateurExist) {
            role = Role.ADMIN.getRole();
        } else {
            role = Role.MEMBRE.getRole();
        }
        loginParam.setRole(role);

        token = JWTUtils.createToken(utilisateur.getId());
        System.out.println("token" + token);
        loginParam.setToken(token);
        loginParam.setPrenom(utilisateur.getPrenom());
        loginParam.setUserId(utilisateur.getId());
        
        return Result.success(loginParam);
    }

    @Override
    public Result logout(String token) {
        return Result.success(null);
    }

/*    @Override
    public Utilisateur checkToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if (stringObjectMap == null) {
            return null;
        }
        int userId = Integer.parseInt(stringObjectMap.get("userId").toString());
        Utilisateur utilisateur = utilisateurService.findById(userId);

        return utilisateur;
    }*/
}
