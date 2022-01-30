package com.ncit.activityLifeCycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ncit.mutlilang.MultiLangActivity;
import com.ncit.projectb.R;

public class LifeCycleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.e("oncreate", "oncreate method called");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "onStart method called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onResume method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "onPause method called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "onStop method called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "onRestart method called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "onDestroy method called");
    }

    public void changeActivity(View view) {
        startActivity(new Intent(LifeCycleActivity.this, MultiLangActivity.class));
    }
}