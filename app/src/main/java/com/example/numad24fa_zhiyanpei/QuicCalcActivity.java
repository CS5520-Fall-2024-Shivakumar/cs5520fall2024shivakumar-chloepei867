package com.example.numad24fa_zhiyanpei;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class QuicCalcActivity extends AppCompatActivity {

    TextView display;
//    String currentText = display.getText().toString();
    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quic_calc);
        display = findViewById(R.id.text_calc_display);

        setClickListener(R.id.button_1, "1");
        setClickListener(R.id.button_2, "2");
        setClickListener(R.id.button_3, "3");
        setClickListener(R.id.button_4, "4");
        setClickListener(R.id.button_5, "5");
        setClickListener(R.id.button_6, "6");
        setClickListener(R.id.button_7, "7");
        setClickListener(R.id.button_8, "8");
        setClickListener(R.id.button_9, "9");
        setClickListener(R.id.button_10, "+");
        setClickListener(R.id.button_11, "0");
        setClickListener(R.id.button_12, "-");
        setClickListener(R.id.button_13, "x");
        setClickListener(R.id.button_14, "=");

    }

    private void setClickListener(int buttonId, String val) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            handClick(val);
        });
    }

    private void handClick(String val) {
        if (val.equals("=")) {
            evaluateExpression();
//            resetDisplay();
        } else if (val.equals("x")) {
            if (input.length() > 0) {
                input.deleteCharAt(input.length()-1);
            }
        } else {
            input.append(val);
        }
        display.setText(input.toString());
    }

    private void evaluateExpression() {
        long res = evaluate(input.toString());
        input = new StringBuilder(String.valueOf(res));
    }


    private long evaluate(String input) {
        int index1 = input.indexOf("+");
        int index2 = input.indexOf("-");
        long res = 0;

        if (index1 != -1) {
            long num1 = Long.parseLong(input.substring(0, index1));
            long num2 = Long.parseLong(input.substring(index1+1));
            res = num1 + num2;
        } else if (index2 != -1) {
            long num1 = Long.parseLong(input.substring(0, index2));
            long num2 = Long.parseLong(input.substring(index2+1));
            res = num1 - num2;
        }
        return res;
    }
}