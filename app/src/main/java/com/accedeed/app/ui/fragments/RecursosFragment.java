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

import com.accedeed.app.databinding.FragmentRecursosBinding;
import com.accedeed.app.viewmodel.RecursosViewModel;

public class RecursosFragment extends Fragment {

    private FragmentRecursosBinding binding;
    private RecursosViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRecursosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RecursosViewModel.class);
        
        binding.rvRecursos.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.tvRecursosTitle.setText("Recursos Disponibles");
    }
}
