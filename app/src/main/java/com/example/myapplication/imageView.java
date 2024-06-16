package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class imageView extends AppCompatActivity {
    public String imageName ;
    public Random randomGenerator = new Random() ;

    public String text = "" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getIntent() != null && getIntent().hasExtra("image")) {
             imageName = getIntent().getStringExtra("image");
        }
        displayImage();
    }

    public void displayImage(){
        ImageView disimg = findViewById(R.id.imgcontainer) ;
        int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        disimg.setImageResource(resID);

    }

    public void RandomText(View v){
        String text1 = "bla bla bla bla bla bla bla bla" ;
        String text2 = "Mi mi mi mi mi mi mi mi mi mi mi";
        String text3 = " HELLLOOOOOO WOOOOOOOORLD";
        String text4 = "BRUUUUUUUUUUUUUUUUUUUUUUUUH" ;

        ArrayList<String> strings = new ArrayList<String>() ;

        strings.add(text1);
        strings.add(text2);
        strings.add(text3);
        strings.add(text4);

        int index = randomGenerator.nextInt(strings.size());

         text = strings.get(index) ;

        TextView txt = findViewById(R.id.t1);

        Button analayze = findViewById(R.id.button2);


        txt.setText(text);

        analayze.setEnabled(false);

        saveHistory.history.add(imageName);
        saveHistory.history.add(text);

        Toast.makeText(this,"Image Saved in History",Toast.LENGTH_SHORT).show();



    }



}

