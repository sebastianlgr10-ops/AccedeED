package com.accedeed.app.model;

public class User {
    private String id;
    private String name;
    private String email;
    private String avatar;

    public User(String id, String name, String email, String avatar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAvatar() { return avatar; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}
