package com.huarique.app.controller;

import com.huarique.app.model.Plato;
import com.huarique.app.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping("/nuevo")
    public String formNuevo(Model model) {
        model.addAttribute("plato", new Plato());
        return "producto-nuevo";
    }

    @PostMapping("/nuevo")
    public String guardarNuevo(@ModelAttribute Plato plato) {
        platoService.agregar(plato);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable int id, Model model) {
        model.addAttribute("plato", platoService.buscarPorId(id));
        return "producto-editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Plato plato) {
        platoService.actualizarCompleto(id, plato);
        return "redirect:/";
    }

    @GetMapping("/editar-precio/{id}")
    public String formEditarPrecio(@PathVariable int id, Model model) {
        model.addAttribute("plato", platoService.buscarPorId(id));
        return "producto-editar-precio";
    }

    @PostMapping("/actualizar-precio/{id}")
    public String actualizarPrecio(@PathVariable int id, @ModelAttribute Plato plato) {
        platoService.actualizarParcial(id, plato.getPrecio(), plato.getEtiqueta());
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        platoService.eliminar(id);
        return "redirect:/";
    }
}
