package com.godin.locationSpring.service;

import com.godin.locationSpring.model.Utilisateur;
import com.godin.locationSpring.vo.Result;
import com.godin.locationSpring.vo.params.LoginParam;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    /**
     * La function de Login
     * @return
     */
    Result login(LoginParam loginParam);

    Result logout(String token);

//    Utilisateur checkToken(String token);
}
