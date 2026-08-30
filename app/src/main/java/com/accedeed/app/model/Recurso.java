package com.accedeed.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recursos")
public class Recurso {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String uid;
    private String title;
    private String description;
    private String category;
    private String resourceUrl;
    private String resourceType; // pdf, video, image, link, etc
    private String subject;
    private int views;
    private int likes;
    private boolean isFavorite;
    private long createdAt;
    private long updatedAt;

    public Recurso() {}

    public Recurso(String title, String description, String category, String subject) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.subject = subject;
        this.views = 0;
        this.likes = 0;
        this.isFavorite = false;
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

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getResourceUrl() { return resourceUrl; }
    public void setResourceUrl(String resourceUrl) { this.resourceUrl = resourceUrl; }

    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public int getViews() { return views; }
    public void setViews(int views) { this.views = views; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }
}
