package com.ncit.projectb;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        EditText etPassword = findViewById(R.id.et_password);
        Button btnResetPassword = findViewById(R.id.btn_reset);
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = etPassword.getText().toString();

                if (pass.isEmpty()) {
                    etPassword.setError(getString(R.string.field_required));
                } else {
                    showConfirmationBox();
                }
            }
        });
    }

    private void showConfirmationBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ResetPassword.this);
        builder.setTitle("Title")
                .setMessage("Message")

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Nop", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNeutralButton("May be", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.create();
        builder.show();

    }


}