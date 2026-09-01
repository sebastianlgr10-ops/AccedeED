package com.accedeed.app.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.accedeed.app.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoRepository {
    private static EventoRepository instance;
    private MutableLiveData<List<Evento>> eventos = new MutableLiveData<>();

    private EventoRepository() {
        loadEventos();
    }

    public static EventoRepository getInstance() {
        if (instance == null) {
            instance = new EventoRepository();
        }
        return instance;
    }

    private void loadEventos() {
        List<Evento> eventoList = new ArrayList<>();
        eventoList.add(new Evento("1", "Webinar: Accesibilidad Web", "Aprende sobre accesibilidad web", "2026-09-15", "14:00", "Online"));
        eventoList.add(new Evento("2", "Taller: Desarrollo Inclusivo", "Taller práctico", "2026-09-20", "16:00", "Online"));
        eventos.setValue(eventoList);
    }

    public LiveData<List<Evento>> getEventos() {
        return eventos;
    }
}
