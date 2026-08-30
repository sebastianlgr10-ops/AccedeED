package com.accedeed.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.accedeed.app.R;
import com.accedeed.app.ui.fragment.HomeFragment;
import com.accedeed.app.ui.fragment.RecursosFragment;
import com.accedeed.app.ui.fragment.EventosFragment;
import com.accedeed.app.ui.fragment.ChatFragment;
import com.accedeed.app.ui.fragment.ProfileFragment;
import com.accedeed.app.utils.PreferenceManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private PreferenceManager preferenceManager;
    private BottomNavigationView bottomNavigationView;
    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceManager = new PreferenceManager(this);

        // Check if logged in
        if (!preferenceManager.isLoggedIn()) {
            navigateToLogin();
            return;
        }

        initializeViews();
        setupBottomNavigation();
        loadHomeFragment();
    }

    private void initializeViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        tvWelcome = findViewById(R.id.tv_welcome);
        
        String userName = preferenceManager.getUserName();
        if (tvWelcome != null) {
            tvWelcome.setText("Bienvenido, " + userName);
        }
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.nav_recursos:
                    loadFragment(new RecursosFragment());
                    return true;
                case R.id.nav_eventos:
                    loadFragment(new EventosFragment());
                    return true;
                case R.id.nav_chat:
                    loadFragment(new ChatFragment());
                    return true;
                case R.id.nav_profile:
                    loadFragment(new ProfileFragment());
                    return true;
            }
            return false;
        });
    }

    private void loadHomeFragment() {
        loadFragment(new HomeFragment());
    }

    private void loadFragment(androidx.fragment.app.Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void navigateToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
