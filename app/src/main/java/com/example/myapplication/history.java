package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class history extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        displayHistoryItems();

    }

    private void displayHistoryItems() {
        LinearLayout container = findViewById(R.id.history_container);
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i < saveHistory.history.size(); i += 2) {
            String imageName = saveHistory.history.get(i);
            String text = saveHistory.history.get(i + 1);

            View view = inflater.inflate(R.layout.img_txt, container, false);

            ImageView imageView = view.findViewById(R.id.img122);
            TextView textView = view.findViewById(R.id.txt122);

            int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            imageView.setImageResource(resID);
            textView.setText(text);

            container.addView(view);
        }
    }
}
