package com.huarique.app.controller;

import com.huarique.app.model.Reserva;
import com.huarique.app.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/reservas/registrar")
    public String registrarReserva(@ModelAttribute Reserva reserva, RedirectAttributes redirectAttributes) {
        reservaService.registrar(reserva);
        redirectAttributes.addFlashAttribute("reservaExitosa", reserva);
        return "redirect:/#reservas";
    }

    @GetMapping("/reservas/estado/{id}/{nuevoEstado}")
    @ResponseBody
    public ResponseEntity<String> cambiarEstado(@PathVariable int id, @PathVariable String nuevoEstado) {
        reservaService.cambiarEstado(id, nuevoEstado);
        return ResponseEntity.ok(nuevoEstado);
    }

    @GetMapping("/reservas/eliminar/{id}")
    public String eliminarReserva(@PathVariable int id) {
        reservaService.eliminar(id);
        return "redirect:/#panel-trabajador";
    }
}

