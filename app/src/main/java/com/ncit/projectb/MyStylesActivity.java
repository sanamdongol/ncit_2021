package com.ncit.projectb;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyStylesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_styles);

        TextView customFontTextView = findViewById(R.id.tv_custom_fonts);
        TextView tvFromFont = findViewById(R.id.tv_fonts_folder);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/cormorant_unicase_bold.ttf");
        customFontTextView.setTypeface(typeface);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Typeface typeFromFonts = getResources().getFont(R.font.light);
            tvFromFont.setTypeface(typeFromFonts);
        }


    }
}