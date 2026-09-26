package com.huarique.app.service;

import com.huarique.app.model.Reserva;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private List<Reserva> reservas = new ArrayList<>();
    private int siguienteId = 1;

    public void registrar(Reserva r) {
        r.setId(siguienteId++);
        reservas.add(r);
    }

    public List<Reserva> listarTodas() {
        return reservas;
    }

    public List<Map.Entry<String, Long>> clientesFrecuentes() {
        Map<String, Long> conteo = reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getNombre, Collectors.counting()));

        return conteo.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toList());
    }
}
