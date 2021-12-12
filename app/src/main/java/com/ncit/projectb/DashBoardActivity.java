package com.ncit.projectb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        TextView tvName = findViewById(R.id.tv_name);


        //Extract data from intent
        Intent intentData = getIntent();
        String intentValue = intentData.getStringExtra("name");
        String cat = intentData.getStringExtra("category");

        tvName.setText(intentValue + "\n" + cat);
        Log.e("catrogy value", cat);

        Log.e("intent value", intentValue);
        Toast.makeText(DashBoardActivity.this, intentValue, Toast.LENGTH_SHORT).show();

        Button btnAnimate = findViewById(R.id.btn_animate);
        ImageView imgView = findViewById(R.id.img);

        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(DashBoardActivity.this, R.anim.blink);
                imgView.startAnimation(animation);
            }
        });


    }
}