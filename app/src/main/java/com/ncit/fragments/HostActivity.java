package com.ncit.fragments;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ncit.projectb.R;

public class HostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu_1:
                        changeFragment(new HomeFragment());
                        return true;
                    case R.id.menu_2:
                        changeFragment(new ShortsFragment());
                        return true;
                    case R.id.menu_3:
                        changeFragment(new ProfileFragment());
                        return true;
                    case R.id.menu_4:
                        changeFragment(new SettingsFragment());
                        return true;
                    case R.id.menu_5:
                        return true;

                }
                return false;
            }
        });

      /*  Button btnHome = findViewById(R.id.btn_home);
        Button btnProfile = findViewById(R.id.btn_profile);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.fragment_container, new HomeFragment());
                transaction.commit();
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.fragment_container, new ProfileFragment());
                transaction.commit();
            }
        });*/
    }

    private void changeFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.zoom_out);
        transaction.replace(R.id.fragment_container, fragment);

        transaction.addToBackStack("randome");
        transaction.commit();
    }
}