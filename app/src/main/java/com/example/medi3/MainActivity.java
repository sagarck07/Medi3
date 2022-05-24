package com.example.medi3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.palette.graphics.Palette;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.medi3.Adapters.FragmentsAdapter;
import com.example.medi3.databinding.ActivityMainBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getParent();



        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewPager);


    }

    public void onStart() {
        super.onStart();

        setTabLayoutAnimation();


        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.pharmacy, null));
        slideModels.add(new SlideModel(R.drawable.pharmacy2, null));
        slideModels.add(new SlideModel(R.drawable.pharmacy3, null));
        slideModels.add(new SlideModel(R.drawable.pharmacy4, null));
        slideModels.add(new SlideModel(R.drawable.pharmacy5, null));
        slideModels.add(new SlideModel(R.drawable.pharmacy6, null));

        binding.imageSlider.setImageList(slideModels);
    }


        private void initToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setTabLayoutAnimation(){
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.CollapsingToolbarLayout);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pharmacy);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int myColor = palette.getVibrantColor(getResources().getColor(R.color.purple_500));
                int myDarkColor = palette.getVibrantColor(getResources().getColor(R.color.purple_500));
                collapsingToolbarLayout.setStatusBarScrimColor(myColor);
                collapsingToolbarLayout.setStatusBarScrimColor(myDarkColor);
            }
        });
    }


}