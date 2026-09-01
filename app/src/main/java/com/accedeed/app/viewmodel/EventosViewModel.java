package com.accedeed.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class EventosViewModel extends ViewModel {
    private MutableLiveData<List<String>> eventos = new MutableLiveData<>();

    public EventosViewModel() {
        loadEventos();
    }

    private void loadEventos() {
        List<String> eventosList = new ArrayList<>();
        eventosList.add("Webinar: Accesibilidad Web");
        eventosList.add("Taller: Desarrollo Inclusivo");
        eventosList.add("Conferencia: Tecnología Asistiva");
        eventos.setValue(eventosList);
    }

    public LiveData<List<String>> getEventos() {
        return eventos;
    }
}
