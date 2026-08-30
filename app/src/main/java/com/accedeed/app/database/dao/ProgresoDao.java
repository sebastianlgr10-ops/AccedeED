package com.accedeed.app.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.accedeed.app.model.Progreso;

import java.util.List;

@Dao
public interface ProgresoDao {
    @Insert
    long insertProgreso(Progreso progreso);

    @Update
    void updateProgreso(Progreso progreso);

    @Delete
    void deleteProgreso(Progreso progreso);

    @Query("SELECT * FROM progresos WHERE id = :id")
    Progreso getProgresoById(int id);

    @Query("SELECT * FROM progresos WHERE uid = :uid")
    List<Progreso> getProgresosByUser(String uid);

    @Query("SELECT * FROM progresos WHERE uid = :uid AND subject = :subject")
    Progreso getProgresoByUserAndSubject(String uid, String subject);

    @Query("SELECT * FROM progresos WHERE subject = :subject ORDER BY percentage DESC")
    List<Progreso> getProgresosBySubject(String subject);

    @Query("SELECT AVG(percentage) FROM progresos WHERE uid = :uid")
    float getTotalProgresoByUser(String uid);

    @Query("SELECT * FROM progresos ORDER BY updatedAt DESC")
    List<Progreso> getAllProgresos();
}
