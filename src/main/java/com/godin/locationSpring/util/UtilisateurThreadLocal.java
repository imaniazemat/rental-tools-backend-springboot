package com.godin.locationSpring.util;

import com.godin.locationSpring.model.Utilisateur;

public class UtilisateurThreadLocal {
    private UtilisateurThreadLocal() {
    }

    private static final ThreadLocal<Utilisateur> LOCAL = new ThreadLocal<>();

    public static void put(Utilisateur utilisateur) {
        LOCAL.set(utilisateur);
    }

    public static Utilisateur get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }
}
