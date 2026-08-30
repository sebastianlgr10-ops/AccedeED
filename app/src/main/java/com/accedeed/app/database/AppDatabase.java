package com.accedeed.app.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.accedeed.app.database.dao.ChatMessageDao;
import com.accedeed.app.database.dao.EventoDao;
import com.accedeed.app.database.dao.ProgresoDao;
import com.accedeed.app.database.dao.RecursoDao;
import com.accedeed.app.database.dao.UserDao;
import com.accedeed.app.model.ChatMessage;
import com.accedeed.app.model.Evento;
import com.accedeed.app.model.Progreso;
import com.accedeed.app.model.Recurso;
import com.accedeed.app.model.User;

@Database(
    entities = {User.class, Recurso.class, Evento.class, Progreso.class, ChatMessage.class},
    version = 1,
    exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    public abstract UserDao userDao();
    public abstract RecursoDao recursoDao();
    public abstract EventoDao eventoDao();
    public abstract ProgresoDao progresoDao();
    public abstract ChatMessageDao chatMessageDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "accedeed_database"
                    )
                    .fallbackToDestructiveMigration()
                    .build();
                }
            }
        }
        return INSTANCE;
    }
}
