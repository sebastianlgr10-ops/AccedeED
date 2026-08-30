package com.accedeed.app.model;

public class Evento {
    private String id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String lugar;
    private String imagen;
    private int asistentes;

    public Evento() {}

    public Evento(String id, String titulo, String descripcion, String fecha, String lugar, String imagen, int asistentes) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.lugar = lugar;
        this.imagen = imagen;
        this.asistentes = asistentes;
    }

    // Getters
    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getFecha() { return fecha; }
    public String getLugar() { return lugar; }
    public String getImagen() { return imagen; }
    public int getAsistentes() { return asistentes; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setLugar(String lugar) { this.lugar = lugar; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public void setAsistentes(int asistentes) { this.asistentes = asistentes; }
}
