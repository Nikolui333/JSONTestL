package com.semenov.jsontestl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        mTextView = (TextView) findViewById(R.id.text);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_circular);

        /**
         * Calling JSON
         */
        Call<CurrencyOperations> call = api.getMyJSON();

        call.enqueue(new Callback<CurrencyOperations>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<CurrencyOperations> call, Response<CurrencyOperations> response) {
                mProgressBar.setVisibility(View.VISIBLE);
                USD usd = response.body().getValute().getUSD();
                Intent intent = new Intent(MainActivity.this, DollarActivity.class);
                intent.putExtra(USD.class.getSimpleName(), usd);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<CurrencyOperations> call, Throwable t) {
                mTextView.setText("Нет подключения к интернету");
            }
        });
    }
}
