package com.accedeed.app.model;

public class Recurso {
    private String id;
    private String title;
    private String description;
    private String url;
    private String category;

    public Recurso(String id, String title, String description, String url, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.category = category;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getUrl() { return url; }
    public String getCategory() { return category; }
}
