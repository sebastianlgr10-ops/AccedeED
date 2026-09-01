package com.accedeed.app.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.accedeed.app.model.User;

public class UserRepository {
    private static UserRepository instance;
    private MutableLiveData<User> currentUser = new MutableLiveData<>();

    private UserRepository() {}

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public LiveData<User> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser.setValue(user);
    }

    public void updateUser(User user) {
        currentUser.setValue(user);
    }
}
