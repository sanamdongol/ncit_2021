package com.ncit.themechange;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.ncit.projectb.R;

public class ThemeChangerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_changer);

        Button btnLight = findViewById(R.id.btn_light);
        Button btnDark = findViewById(R.id.btn_dark);
        Button btnSys = findViewById(R.id.btn_sys);
        Button btnNewAct = findViewById(R.id.btn_new_act);

        btnDark.setOnClickListener(this);
        btnSys.setOnClickListener(this);
        btnLight.setOnClickListener(this);
        btnNewAct.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_light:
                Toast.makeText(ThemeChangerActivity.this, "Changing to Light theme", Toast.LENGTH_SHORT).show();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case R.id.btn_dark:
                Toast.makeText(ThemeChangerActivity.this, "Changing to Dark theme", Toast.LENGTH_SHORT).show();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case R.id.btn_sys:
                Toast.makeText(ThemeChangerActivity.this, "Changing to Sys theme", Toast.LENGTH_SHORT).show();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
            case R.id.btn_new_act:
                Toast.makeText(ThemeChangerActivity.this, "Changing to Sys theme", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ThemeChangerActivity.this, MyThemeActivity.class));
                break;
        }

    }
}