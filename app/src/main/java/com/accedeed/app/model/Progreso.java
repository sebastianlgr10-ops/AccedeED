package com.accedeed.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "progresos")
public class Progreso {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String uid;
    private String subject;
    private float percentage;
    private int completedTopics;
    private int totalTopics;
    private int score;
    private String lastActivityDate;
    private long updatedAt;

    public Progreso() {}

    public Progreso(String uid, String subject, float percentage) {
        this.uid = uid;
        this.subject = subject;
        this.percentage = percentage;
        this.updatedAt = System.currentTimeMillis();
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public float getPercentage() { return percentage; }
    public void setPercentage(float percentage) { this.percentage = percentage; }

    public int getCompletedTopics() { return completedTopics; }
    public void setCompletedTopics(int completedTopics) { this.completedTopics = completedTopics; }

    public int getTotalTopics() { return totalTopics; }
    public void setTotalTopics(int totalTopics) { this.totalTopics = totalTopics; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getLastActivityDate() { return lastActivityDate; }
    public void setLastActivityDate(String lastActivityDate) { this.lastActivityDate = lastActivityDate; }

    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }
}
