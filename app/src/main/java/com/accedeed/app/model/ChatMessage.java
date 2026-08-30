package com.accedeed.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "chat_messages")
public class ChatMessage {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String uid;
    private String message;
    private String response;
    private String senderType; // user, ai
    private long timestamp;
    private boolean isRead;

    public ChatMessage() {}

    public ChatMessage(String uid, String message, String senderType) {
        this.uid = uid;
        this.message = message;
        this.senderType = senderType;
        this.timestamp = System.currentTimeMillis();
        this.isRead = false;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }

    public String getSenderType() { return senderType; }
    public void setSenderType(String senderType) { this.senderType = senderType; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }
}
