package com.huarique.app.model;

public class Reserva {
    private int id;
    private String nombre;
    private String telefono;
    private String sede;
    private String fecha;
    private String hora;
    private int personas;
    private String estado;

    public Reserva() {
        this.estado = "Pendiente";
    }

    public Reserva(int id, String nombre, String telefono, String sede, String fecha, String hora, int personas, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.sede = sede;
        this.fecha = fecha;
        this.hora = hora;
        this.personas = personas;
        this.estado = (estado != null && !estado.isEmpty()) ? estado : "Pendiente";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getSede() { return sede; }
    public void setSede(String sede) { this.sede = sede; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public int getPersonas() { return personas; }
    public void setPersonas(int personas) { this.personas = personas; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

