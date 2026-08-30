package com.accedeed.app.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.accedeed.app.model.Recurso;

import java.util.List;

@Dao
public interface RecursoDao {
    @Insert
    long insertRecurso(Recurso recurso);

    @Update
    void updateRecurso(Recurso recurso);

    @Delete
    void deleteRecurso(Recurso recurso);

    @Query("SELECT * FROM recursos WHERE id = :id")
    Recurso getRecursoById(int id);

    @Query("SELECT * FROM recursos WHERE subject = :subject")
    List<Recurso> getRecursosBySubject(String subject);

    @Query("SELECT * FROM recursos WHERE category = :category")
    List<Recurso> getRecursosByCategory(String category);

    @Query("SELECT * FROM recursos WHERE isFavorite = 1")
    List<Recurso> getFavoriteRecursos();

    @Query("SELECT * FROM recursos ORDER BY createdAt DESC")
    List<Recurso> getAllRecursos();

    @Query("SELECT * FROM recursos WHERE uid = :uid ORDER BY createdAt DESC")
    List<Recurso> getRecursosByUser(String uid);

    @Query("DELETE FROM recursos WHERE id = :id")
    void deleteRecursoById(int id);
}
