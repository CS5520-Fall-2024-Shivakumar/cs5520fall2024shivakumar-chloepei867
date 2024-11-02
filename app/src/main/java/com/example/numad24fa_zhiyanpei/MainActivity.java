package com.example.numad24fa_zhiyanpei;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView helloTextView = findViewById(R.id.hello_text);

        Button aboutMeButton = findViewById(R.id.about_me_button);
        Button quicCalcButton = findViewById(R.id.quic_calc_button);


        Context context = this;
        aboutMeButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
            startActivity(intent);
        });

        quicCalcButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuicCalcActivity.class);
            startActivity(intent);
        });
    }
}