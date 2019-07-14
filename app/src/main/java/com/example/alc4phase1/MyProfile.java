package com.example.alc4phase1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MyProfile extends AppCompatActivity {
    public ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        mImageView =  findViewById(R.id.imageView2);
        Glide.with(this).load(R.drawable.oryn).into(mImageView);


    }
}
