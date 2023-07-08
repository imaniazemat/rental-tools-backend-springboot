package com.godin.locationSpring.controller;


import com.godin.locationSpring.model.Utilisateur;
import com.godin.locationSpring.util.UtilisateurThreadLocal;
import com.godin.locationSpring.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public Result test() {
        Utilisateur utilisateur = UtilisateurThreadLocal.get();
        System.out.println(utilisateur);
        return Result.success(null);
    }
}
