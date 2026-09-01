package com.accedeed.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> welcomeMessage = new MutableLiveData<>();

    public HomeViewModel() {
        welcomeMessage.setValue("Bienvenido a AccedeED");
    }

    public LiveData<String> getWelcomeMessage() {
        return welcomeMessage;
    }
}
