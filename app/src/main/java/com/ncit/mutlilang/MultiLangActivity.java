package com.ncit.mutlilang;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ncit.projectb.R;

import java.util.Locale;

public class MultiLangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_lang);

        Button btnLanguage = findViewById(R.id.btn_select_lang);
        btnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLanguageOptions();
            }
        });
    }

    private void showLanguageOptions() {
        String[] languages = {"English", "Nepali", "French"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MultiLangActivity.this);
        builder.setTitle("Choose any language");
        builder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int options) {
                switch (options) {
                    case 0:
                        setLocale("en");
                        recreate();
                        break;
                    case 1:
                        setLocale("ne");
                        recreate();
                        break;
                    case 2:
                        setLocale("fr");
                        recreate();
                        break;


                }
            }
        });
        builder.create();
        builder.show();

    }

    private void setLocale(String language) {

        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.locale = locale;

        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }
}