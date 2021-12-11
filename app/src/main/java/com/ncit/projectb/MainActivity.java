package com.ncit.projectb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etPass = findViewById(R.id.et_password);
        Button btnResetPassword = findViewById(R.id.btn_forgot_password);
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,
                        ResetPassword.class));
            }
        });


    }


    public void onLogin(View view) {

        String name = etName.getText().toString();
        String password = etPass.getText().toString();

        boolean hasError = false;
        if (name.isEmpty()) {
            etName.setError(getString(R.string.field_required));
            hasError = true;
        }

        if (password.isEmpty()) {
            etPass.setError(getString(R.string.field_required));
            hasError = true;
        }

        if (!hasError) {
            String[] daysOfWeek = {"Sunday", "Monday", "Tuesday"};

            boolean isTrumpGood = false;
            Intent intentObject = new Intent(MainActivity.this,
                    DashBoardActivity.class);
            intentObject.putExtra("name", "Trump");
            intentObject.putExtra("category", "evil");
            intentObject.putExtra("work", "destruction");
            intentObject.putExtra("bool", isTrumpGood);
            intentObject.putExtra("weekdays", daysOfWeek);
            startActivity(intentObject);

        }


    }
}