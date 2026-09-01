package com.accedeed.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ChatViewModel extends ViewModel {
    private MutableLiveData<List<String>> messages = new MutableLiveData<>();

    public ChatViewModel() {
        messages.setValue(new ArrayList<>());
    }

    public void sendMessage(String message) {
        List<String> currentMessages = messages.getValue();
        if (currentMessages != null) {
            currentMessages.add(message);
            messages.setValue(currentMessages);
        }
    }

    public LiveData<List<String>> getMessages() {
        return messages;
    }
}
