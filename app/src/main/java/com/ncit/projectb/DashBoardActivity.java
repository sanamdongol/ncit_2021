package com.ncit.projectb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashBoardActivity extends AppCompatActivity {


    String[] months = {"Jan", "Feb", "Mar", "Apr"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        SharedPreferences prefs = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        String name = prefs.getString(Constants.USER_NAME, "");
        Log.e("value form pref", name);
        Boolean myBool = prefs.getBoolean("isTrue", false);
        Log.e("booooooooll", myBool.toString());

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

        Spinner spinner = findViewById(R.id.spinner);

       /*ArrayAdapter<String> adapter= new ArrayAdapter<String>(
                DashBoardActivity.this,
                R.layout.row_spinner,
               months);*/
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                DashBoardActivity.this,
                R.array.weeks,
                R.layout.row_spinner);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = adapterView.getItemAtPosition(position).toString();
                Log.e("xxxx", selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(DashBoardActivity.this, R.anim.blink);
                imgView.startAnimation(animation);
            }
        });


    }
}