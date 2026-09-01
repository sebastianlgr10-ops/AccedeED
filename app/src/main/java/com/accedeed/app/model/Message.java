package com.accedeed.app.model;

public class Message {
    private String id;
    private String userId;
    private String content;
    private long timestamp;
    private boolean isFromUser;

    public Message(String id, String userId, String content, long timestamp, boolean isFromUser) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
        this.isFromUser = isFromUser;
    }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getContent() { return content; }
    public long getTimestamp() { return timestamp; }
    public boolean isFromUser() { return isFromUser; }
}
