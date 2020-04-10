package com.semenov.jsontestl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DollarActivity extends AppCompatActivity {

    TextView mTextView;
    Button mDollarButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dollar);

        mTextView = (TextView) findViewById(R.id.dollarText);

        Bundle arguments = getIntent().getExtras();
        USD usd = arguments.getParcelable(USD.class.getSimpleName());

        mTextView.setText("Валюта: " + usd.getName() + "\nКурс: " + usd.getValue());

        mDollarButton = (Button) findViewById(R.id.dollarButton);
        mDollarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDollarButton.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(DollarActivity.this, WebViewActivity.class);
                startActivity(intent);
            }

        });

    }
}
