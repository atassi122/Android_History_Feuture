package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private Random randomGenerator = new Random();
    private String generatedImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public String pickRandomImage() {
        ArrayList<String> pics = new ArrayList<String>();

        pics.add("andorid1");
        pics.add("andorid2");
        pics.add("andorid3");
        pics.add("andorid4");

        int index = randomGenerator.nextInt(pics.size());


        return pics.get(index);
    }

    public void startActivity(View v) {
        generatedImg = pickRandomImage();
        Intent intent = new Intent(this, imageView.class);
        intent.putExtra("image", generatedImg);// Pass the random image name
        startActivity(intent);
    }

    public void startActivityHistory(View v) {
        Intent i = new Intent(this, history.class);
        getIntent().putExtra("image", generatedImg);
        startActivity(i);

    }




}
