package com.ncit.projectb;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MyChipsActivity extends AppCompatActivity {
    String[] fruits = {"Mango", "Banana", "Pear", "Apple", "Pomegranate", "Guava"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_chips);
        Chip chipNormal = findViewById(R.id.chip_normal);
        Chip chipWithClose = findViewById(R.id.chip_with_close);

        ChipGroup chipGroup = findViewById(R.id.chips_group);


        for (int i = 0; i < fruits.length; i++) {
            Chip chip = new Chip(this);
            chip.setText(fruits[i]);
            chip.setTag(fruits[i]);
            chipGroup.addView(chip);

            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String chipTag = view.getTag().toString();
                    Toast.makeText(MyChipsActivity.this,
                            chipTag, Toast.LENGTH_SHORT).show();
                }
            });
        }

        chipNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyChipsActivity.this,
                        "Normal Chip Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        chipWithClose.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyChipsActivity.this,
                        "Close icon Chip Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}