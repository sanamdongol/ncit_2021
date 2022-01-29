package com.ncit.picaglide;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.ncit.projectb.R;
import com.squareup.picasso.Picasso;

public class PicaGlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pica_glide);

        ImageView imgPicaso = findViewById(R.id.img_pica);
        ImageView imgGlide = findViewById(R.id.img_glide);
        String imgUrl = "https://images.unsplash.com/photo-1643397652696-e633822828fd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=985&q=80";
        Picasso
                .get()
                .load(imgUrl)
                .placeholder(R.drawable.ic_settings)
                .error(R.drawable.random_vect)
                .into(imgPicaso);


        //Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);

        String imgLink = "https://images.unsplash.com/photo-1494976388531-d1058494cdd8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80";
        Glide.with(this).load(imgLink).into(imgGlide);

    }
}