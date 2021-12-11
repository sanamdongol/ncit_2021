package com.ncit.projectb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonEvents extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_events);

        Button btnTwo = findViewById(R.id.btn_two);
        Button btnFour = findViewById(R.id.btn_4);
        Button btnThree = findViewById(R.id.btn_3);
        Button btnFive = findViewById(R.id.btn_5);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);

        //direct events settings
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    //from xml
    public void showLog(View view) {
        Log.e("button one tag", "Button one clicked");
    }

    @Override
    public void onClick(View view) {
        int btnIds = view.getId();
        switch (btnIds){
            case R.id.btn_3:
                Log.e("button one tag", "Button one clicked");
                break;
            case R.id.btn_4:
                Log.e("button one tag", "Button one clicked");
                break;
            case R.id.btn_5:
                Log.e("button one tag", "Button one clicked");
                break;
        }

        /*if(btnIds==R.id.btn_3){

        }

        if(btnIds==R.id.btn_4){

        }*/

    }
}