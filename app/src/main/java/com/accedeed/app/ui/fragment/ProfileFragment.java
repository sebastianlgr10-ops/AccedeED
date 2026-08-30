package com.accedeed.app.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.accedeed.app.R;
import com.accedeed.app.ui.activity.LoginActivity;
import com.accedeed.app.utils.PreferenceManager;

import android.content.Intent;

public class ProfileFragment extends Fragment {
    private TextView tvName, tvEmail, tvUserId;
    private Button btnLogout, btnEditProfile;
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preferenceManager = new PreferenceManager(getContext());
        tvName = view.findViewById(R.id.tv_name);
        tvEmail = view.findViewById(R.id.tv_email);
        tvUserId = view.findViewById(R.id.tv_user_id);
        btnLogout = view.findViewById(R.id.btn_logout);
        btnEditProfile = view.findViewById(R.id.btn_edit_profile);

        loadUserProfile();
        setupListeners();
    }

    private void loadUserProfile() {
        String name = preferenceManager.getUserName();
        String email = preferenceManager.getUserEmail();
        String userId = preferenceManager.getUserId();

        tvName.setText(name);
        tvEmail.setText(email);
        tvUserId.setText("ID: " + userId);
    }

    private void setupListeners() {
        btnLogout.setOnClickListener(v -> logout());
        btnEditProfile.setOnClickListener(v -> Toast.makeText(getContext(), "Editar perfil próximamente", Toast.LENGTH_SHORT).show());
    }

    private void logout() {
        preferenceManager.setIsLoggedIn(false);
        preferenceManager.clearUserData();
        startActivity(new Intent(getContext(), LoginActivity.class));
        getActivity().finish();
    }
}
