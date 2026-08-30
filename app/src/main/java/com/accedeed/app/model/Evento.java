package com.accedeed.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "eventos")
public class Evento {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String uid;
    private String title;
    private String description;
    private String location;
    private long startDate;
    private long endDate;
    private String subject;
    private String eventType; // tarea, examen, clase, otro
    private int reminder; // minutos antes
    private boolean isCompleted;
    private long createdAt;
    private long updatedAt;

    public Evento() {}

    public Evento(String title, String description, long startDate, String subject) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.subject = subject;
        this.isCompleted = false;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public long getStartDate() { return startDate; }
    public void setStartDate(long startDate) { this.startDate = startDate; }

    public long getEndDate() { return endDate; }
    public void setEndDate(long endDate) { this.endDate = endDate; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public int getReminder() { return reminder; }
    public void setReminder(int reminder) { this.reminder = reminder; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }
}
