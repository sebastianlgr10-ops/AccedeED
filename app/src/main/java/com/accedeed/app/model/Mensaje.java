package com.accedeed.app.model;

public class Mensaje {
    private String id;
    private String userId;
    private String texto;
    private long timestamp;
    private String usuario;

    public Mensaje() {}

    public Mensaje(String userId, String texto, long timestamp) {
        this.userId = userId;
        this.texto = texto;
        this.timestamp = timestamp;
    }

    public Mensaje(String id, String userId, String texto, long timestamp, String usuario) {
        this.id = id;
        this.userId = userId;
        this.texto = texto;
        this.timestamp = timestamp;
        this.usuario = usuario;
    }

    // Getters
    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getTexto() { return texto; }
    public long getTimestamp() { return timestamp; }
    public String getUsuario() { return usuario; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setTexto(String texto) { this.texto = texto; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
}
