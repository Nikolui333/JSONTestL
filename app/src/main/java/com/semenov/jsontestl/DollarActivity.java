package com.semenov.jsontestl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class DollarActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dollar);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();
        USD usd = arguments.getParcelable(USD.class.getSimpleName());

        textView.setText("Валюта: " + usd.getName() + "\nКурс: " + usd.getValue());
        setContentView(textView);
    }
}
