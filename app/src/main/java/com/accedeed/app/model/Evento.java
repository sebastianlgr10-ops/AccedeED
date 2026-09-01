package com.accedeed.app.model;

public class Evento {
    private String id;
    private String title;
    private String description;
    private String date;
    private String time;
    private String location;

    public Evento(String id, String title, String description, String date, String time, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getLocation() { return location; }
}
