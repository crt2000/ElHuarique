package com.huarique.app.controller;

import com.huarique.app.model.Reserva;
import com.huarique.app.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/reservas/registrar")
    public String registrarReserva(@ModelAttribute Reserva reserva) {
        reservaService.registrar(reserva);
        return "redirect:/";
    }
}
