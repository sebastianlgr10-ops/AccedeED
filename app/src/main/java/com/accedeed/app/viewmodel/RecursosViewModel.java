package com.accedeed.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecursosViewModel extends ViewModel {
    private MutableLiveData<List<String>> recursos = new MutableLiveData<>();

    public RecursosViewModel() {
        loadRecursos();
    }

    private void loadRecursos() {
        List<String> recursosList = new ArrayList<>();
        recursosList.add("Guía de Accesibilidad");
        recursosList.add("Tutoriales en Vídeo");
        recursosList.add("Documentación");
        recursos.setValue(recursosList);
    }

    public LiveData<List<String>> getRecursos() {
        return recursos;
    }
}
