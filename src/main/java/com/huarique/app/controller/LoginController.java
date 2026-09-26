package com.huarique.app.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final String USUARIO = "trabajador";
    private static final String CLAVE = "1234";

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String clave, HttpSession session) {
        if (USUARIO.equals(usuario) && CLAVE.equals(clave)) {
            session.setAttribute("trabajador", true);
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}