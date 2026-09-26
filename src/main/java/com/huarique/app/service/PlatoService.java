package com.huarique.app.service;

import com.huarique.app.model.Plato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoService {

    private List<Plato> platosDestacados = new ArrayList<>();
    private int siguienteId = 10; // los 9 primeros ya usan los ids 1 a 9

    public PlatoService() {
        platosDestacados.add(new Plato(1, "Ceviche Mixto", "Pescado y mariscos frescos en leche de tigre", 38.0, "img/ceviche-mixto.jpg", "Popular"));
        platosDestacados.add(new Plato(2, "Chicharrón Mixto", "Pescado y mariscos apanados y fritos", 35.0, "img/chicharron-mixto.jpg", "Popular"));
        platosDestacados.add(new Plato(3, "Parrilla Mixta", "Selección de carnes a la parrilla", 55.0, "img/parrilla-mixta.jpg", "Parrilla"));
        platosDestacados.add(new Plato(4, "Leche de Tigre", "Clásico jugo de cocción del ceviche", 18.0, "img/leche-de-tigre.jpg", "Entrada"));
        platosDestacados.add(new Plato(5, "Combo Chihuan 1", "Combo de entrada y fondo", 60.0, "img/combo-chihuan-1.jpg", "Oferta"));
        platosDestacados.add(new Plato(6, "Anticuchos", "Brochetas de corazón a la parrilla", 20.0, "img/anticuchos.jpg", "Parrilla"));
        platosDestacados.add(new Plato(7, "Combo Familiar 1", "Combo para 4 personas", 90.0, "img/combo-familiar-1.jpg", "Oferta"));
        platosDestacados.add(new Plato(8, "Chicha Morada", "Bebida tradicional peruana", 10.0, "img/chicha-morada.jpg", "Bebida"));
        platosDestacados.add(new Plato(9, "Papa Rellena", "Papa rellena con guiso de carne", 12.0, "img/papa-rellena.jpg", "Entrada"));
    }

    public List<Plato> listarDestacados() {
        return platosDestacados;
    }

    public Plato buscarPorId(int id) {
        for (Plato p : platosDestacados) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void agregar(Plato p) {
        p.setId(siguienteId++);
        platosDestacados.add(p);
    }

    public void actualizarCompleto(int id, Plato datos) {
        Plato p = buscarPorId(id);
        if (p != null) {
            p.setNombre(datos.getNombre());
            p.setDescripcion(datos.getDescripcion());
            p.setPrecio(datos.getPrecio());
            p.setImagenUrl(datos.getImagenUrl());
            p.setEtiqueta(datos.getEtiqueta());
        }
    }

    public void actualizarParcial(int id, double precio, String etiqueta) {
        Plato p = buscarPorId(id);
        if (p != null) {
            p.setPrecio(precio);
            p.setEtiqueta(etiqueta);
        }
    }

    public void eliminar(int id) {
        platosDestacados.removeIf(p -> p.getId() == id);
    }
}
