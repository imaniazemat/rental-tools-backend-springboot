package com.godin.locationSpring.service.impl;

import com.godin.locationSpring.model.Utilisateur;
import com.godin.locationSpring.service.TokenService;
import com.godin.locationSpring.service.UtilisateurService;
import com.godin.locationSpring.util.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public Integer checkToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if (stringObjectMap == null) {
            return null;
        }
        int userId = Integer.parseInt(stringObjectMap.get("userId").toString());

        return userId;
    }
}
