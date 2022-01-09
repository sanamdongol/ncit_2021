package com.ncit.custom;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;
import com.ncit.projectb.R;

public class CustomActivity extends AppCompatActivity {

    //Janak, anil, Ayush, Rajan, Nitesh Dhungana, Sandeep Ghimire

    String settingTitles[] = {"Account", "General", "Bottom Appbar"};
    // Image settingImages[] = {android.R.drawable.star_big_off,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        //TODO: clean thi code harry

        Button btnDefaultToast = findViewById(R.id.btn_default_toast);
        Button btnChangePos = findViewById(R.id.btn_change_pos);
        Button btnCustomSnack = findViewById(R.id.btn_custom_snack);
        Button btnDefaultSnack = findViewById(R.id.btn_defautl_snack);
        Button btnBottom = findViewById(R.id.btn_bottom);
        Button btnCustomDialog = findViewById(R.id.btn_custom_dialog);
        Button btnDefaultDialog = findViewById(R.id.btn_default_dialog);
        LinearLayout linearLayout = findViewById(R.id.linearlayout);

        LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < 9; i++) {
            View myView = inflater.inflate(R.layout.custom_linear, linearLayout, false);
            ImageView image = myView.findViewById(R.id.imageView10);
            TextView tv = myView.findViewById(R.id.textView14);

            tv.setText(settingTitles[0]);
            linearLayout.addView(myView);
        }

        ConstraintLayout mainLayout = findViewById(R.id.mainLayout);
        btnDefaultToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(CustomActivity.this, "Default Toast", Toast.LENGTH_SHORT);

                toast.show();
            }
        });
        btnChangePos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(CustomActivity.this, "Default Toast", Toast.LENGTH_SHORT);
                LayoutInflater layoutInflater = getLayoutInflater();
                View toastView = layoutInflater.inflate(R.layout.toast_layout, null);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                toast.setView(toastView);
                toast.show();
            }
        });

        btnDefaultSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mainLayout, "Default Snackbar", Snackbar.LENGTH_LONG).show();
            }
        });

        btnCustomSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackBar = Snackbar.make(mainLayout, "Default Snackbar", Snackbar.LENGTH_LONG);
                LayoutInflater inflater = getLayoutInflater();
                View customSnackBar = inflater.inflate(R.layout.custom_snack_bar, null);


                Snackbar.SnackbarLayout snackBarView = (Snackbar.SnackbarLayout) snackBar.getView();
                snackBarView.addView(customSnackBar);

                snackBar.setAnchorView(btnBottom);

                snackBar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(CustomActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    }
                });
                snackBar.show();
            }
        });


        btnDefaultDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomActivity.this);
                builder.setTitle("Title");
                builder.setMessage("Message");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomActivity.this);
                LayoutInflater layoutInflater = getLayoutInflater();
                View customView = layoutInflater.inflate(R.layout.custom_dialog, null);
                Button btnYes = customView.findViewById(R.id.btn_yes);
                Button btnNo = customView.findViewById(R.id.btn_no);
                Button btnMayBe = customView.findViewById(R.id.btn_may_be);

                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(CustomActivity.this, "Yes button", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setView(customView);
                builder.create();
                builder.show();
            }
        });
    }
}