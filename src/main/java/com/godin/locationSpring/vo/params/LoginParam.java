package com.godin.locationSpring.vo.params;

import lombok.Data;

@Data
public class LoginParam {
    private String courriel;
    private String password;
    private String role;
    private String token;
    private String prenom;
    private int userId;
}
