package com.accedeed.app.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.accedeed.app.model.Recurso;

import java.util.ArrayList;
import java.util.List;

public class RecursoRepository {
    private static RecursoRepository instance;
    private MutableLiveData<List<Recurso>> recursos = new MutableLiveData<>();

    private RecursoRepository() {
        loadRecursos();
    }

    public static RecursoRepository getInstance() {
        if (instance == null) {
            instance = new RecursoRepository();
        }
        return instance;
    }

    private void loadRecursos() {
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(new Recurso("1", "Guía de Accesibilidad", "Aprende sobre accesibilidad", "http://ejemplo.com", "Educación"));
        recursoList.add(new Recurso("2", "Tutoriales en Vídeo", "Tutoriales prácticos", "http://ejemplo.com", "Video"));
        recursos.setValue(recursoList);
    }

    public LiveData<List<Recurso>> getRecursos() {
        return recursos;
    }
}
