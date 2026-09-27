package com.huarique.app.model;

public class Plato {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String imagenUrl;
    private String etiqueta;
    private String colorEtiqueta;

    public Plato() {
        this.colorEtiqueta = "bg-primary";
    }

    public Plato(int id, String nombre, String descripcion, double precio, String imagenUrl, String etiqueta) {
        this(id, nombre, descripcion, precio, imagenUrl, etiqueta, "bg-primary");
    }

    public Plato(int id, String nombre, String descripcion, double precio, String imagenUrl, String etiqueta, String colorEtiqueta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.etiqueta = etiqueta;
        this.colorEtiqueta = (colorEtiqueta != null && !colorEtiqueta.isEmpty()) ? colorEtiqueta : "bg-primary";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

    public String getEtiqueta() { return etiqueta; }
    public void setEtiqueta(String etiqueta) { this.etiqueta = etiqueta; }

    public String getColorEtiqueta() { return colorEtiqueta; }
    public void setColorEtiqueta(String colorEtiqueta) { this.colorEtiqueta = colorEtiqueta; }
}
