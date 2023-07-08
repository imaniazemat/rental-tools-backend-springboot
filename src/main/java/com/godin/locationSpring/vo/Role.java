package com.godin.locationSpring.vo;

public enum Role {
    ADMIN("admin"),
    MEMBRE("membre"),
    ;

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
