package com.accedeed.app.network.dto;

public class LoginResponse {
    private String uid;
    private String email;
    private String name;
    private String token;

    public LoginResponse() {}

    public LoginResponse(String uid, String email, String name, String token) {
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.token = token;
    }

    // Getters
    public String getUid() { return uid; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getToken() { return token; }

    // Setters
    public void setUid(String uid) { this.uid = uid; }
    public void setEmail(String email) { this.email = email; }
    public void setName(String name) { this.name = name; }
    public void setToken(String token) { this.token = token; }
}
