package com.accedeed.app.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.accedeed.app.model.ChatMessage;

import java.util.List;

@Dao
public interface ChatMessageDao {
    @Insert
    long insertMessage(ChatMessage message);

    @Update
    void updateMessage(ChatMessage message);

    @Delete
    void deleteMessage(ChatMessage message);

    @Query("SELECT * FROM chat_messages WHERE id = :id")
    ChatMessage getMessageById(int id);

    @Query("SELECT * FROM chat_messages WHERE uid = :uid ORDER BY timestamp DESC")
    List<ChatMessage> getMessagesByUser(String uid);

    @Query("SELECT * FROM chat_messages WHERE uid = :uid AND senderType = :senderType ORDER BY timestamp DESC LIMIT :limit")
    List<ChatMessage> getRecentMessages(String uid, String senderType, int limit);

    @Query("SELECT * FROM chat_messages ORDER BY timestamp DESC")
    List<ChatMessage> getAllMessages();

    @Query("DELETE FROM chat_messages WHERE id = :id")
    void deleteMessageById(int id);

    @Query("DELETE FROM chat_messages WHERE uid = :uid")
    void deleteUserMessages(String uid);
}
