package com.accedeed.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<String> userName = new MutableLiveData<>();
    private MutableLiveData<String> userEmail = new MutableLiveData<>();

    public ProfileViewModel() {
        userName.setValue("Usuario");
        userEmail.setValue("usuario@accedeed.com");
    }

    public LiveData<String> getUserName() {
        return userName;
    }

    public LiveData<String> getUserEmail() {
        return userEmail;
    }
}
