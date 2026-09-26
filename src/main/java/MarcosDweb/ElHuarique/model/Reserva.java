package MarcosDweb.ElHuarique.model;

public class Reserva {
    private int id;
    private String nombre;
    private String telefono;
    private String sede;
    private String fecha;
    private String hora;
    private int personas;

    public Reserva() {
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
}
