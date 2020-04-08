package com.semenov.jsontestl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class DollarActivity extends AppCompatActivity {

    TextView mTextView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dollar);

        mTextView = (TextView) findViewById(R.id.dollarText);

        Bundle arguments = getIntent().getExtras();
        USD usd = arguments.getParcelable(USD.class.getSimpleName());

        mTextView.setText("Валюта: " + usd.getName() + "\nКурс: " + usd.getValue());
    }
}
