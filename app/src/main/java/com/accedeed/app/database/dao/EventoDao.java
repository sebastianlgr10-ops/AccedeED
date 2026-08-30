package com.accedeed.app.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.accedeed.app.model.Evento;

import java.util.List;

@Dao
public interface EventoDao {
    @Insert
    long insertEvento(Evento evento);

    @Update
    void updateEvento(Evento evento);

    @Delete
    void deleteEvento(Evento evento);

    @Query("SELECT * FROM eventos WHERE id = :id")
    Evento getEventoById(int id);

    @Query("SELECT * FROM eventos WHERE subject = :subject")
    List<Evento> getEventosBySubject(String subject);

    @Query("SELECT * FROM eventos WHERE uid = :uid ORDER BY startDate ASC")
    List<Evento> getEventosByUser(String uid);

    @Query("SELECT * FROM eventos WHERE isCompleted = 0 ORDER BY startDate ASC")
    List<Evento> getPendingEventos();

    @Query("SELECT * FROM eventos WHERE startDate BETWEEN :startDate AND :endDate ORDER BY startDate ASC")
    List<Evento> getEventosByDateRange(long startDate, long endDate);

    @Query("SELECT * FROM eventos ORDER BY startDate ASC")
    List<Evento> getAllEventos();

    @Query("DELETE FROM eventos WHERE id = :id")
    void deleteEventoById(int id);
}
