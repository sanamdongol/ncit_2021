package com.ncit.mutlilang;

import static android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ncit.projectb.R;

import java.util.Locale;

public class MultiLangActivity extends AppCompatActivity {


    BroadcastReceiver receiver;

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

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(MultiLangActivity.this, "Airplane mode changed", Toast.LENGTH_SHORT).show();
            }
        };
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

    @Override
    protected void onResume() {
        super.onResume();
        MultiLangActivity.this.registerReceiver(receiver,
                new IntentFilter(ACTION_AIRPLANE_MODE_CHANGED));
    }

    @Override
    protected void onPause() {
        super.onPause();
        MultiLangActivity.this.unregisterReceiver(receiver);
    }
}