package com.huarique.app.controller;

import com.huarique.app.model.Reserva;
import com.huarique.app.service.PlatoService;
import com.huarique.app.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PlatoService platoService;

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        model.addAttribute("platos", platoService.listarDestacados());
        model.addAttribute("reserva", new Reserva());

        Boolean esTrabajador = (Boolean) session.getAttribute("trabajador");
        if (esTrabajador == null) {
            esTrabajador = false;
        }
        model.addAttribute("esTrabajador", esTrabajador);

        if (esTrabajador) {
            model.addAttribute("reservas", reservaService.listarTodas());
            model.addAttribute("clientesFrecuentes", reservaService.clientesFrecuentes());
        }

        return "index";
    }
}