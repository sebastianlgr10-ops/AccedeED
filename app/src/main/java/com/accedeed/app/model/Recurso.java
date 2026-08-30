package com.accedeed.app.model;

public class Recurso {
    private String id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private String imageUrl;
    private String url;
    private String autor;

    public Recurso() {}

    public Recurso(String id, String titulo, String descripcion, String categoria, String imageUrl, String url, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imageUrl = imageUrl;
        this.url = url;
        this.autor = autor;
    }

    // Getters
    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getCategoria() { return categoria; }
    public String getImageUrl() { return imageUrl; }
    public String getUrl() { return url; }
    public String getAutor() { return autor; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setUrl(String url) { this.url = url; }
    public void setAutor(String autor) { this.autor = autor; }
}
