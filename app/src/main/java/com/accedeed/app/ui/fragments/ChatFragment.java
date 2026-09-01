package com.accedeed.app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.accedeed.app.databinding.FragmentChatBinding;
import com.accedeed.app.viewmodel.ChatViewModel;

public class ChatFragment extends Fragment {

    private FragmentChatBinding binding;
    private ChatViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ChatViewModel.class);
        
        binding.rvMessages.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.tvChatTitle.setText("Chat de Soporte");
        
        binding.btnSend.setOnClickListener(v -> sendMessage());
    }

    private void sendMessage() {
        String message = binding.etMessage.getText().toString();
        if (!message.isEmpty()) {
            binding.etMessage.setText("");
            // Send message logic
        }
    }
}
