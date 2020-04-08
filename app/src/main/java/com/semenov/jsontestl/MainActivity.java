package com.semenov.jsontestl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private TextView mTextViewNumCode;
    private TextView mTextViewName;
    private TextView mTextViewValue;
    private ProgressBar mProgressBar;
 //   private CurrencyOperations operations;
  //  private ArrayList<CurrencyOperations> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<CurrencyOperations> call = api.getMyJSON();

        mTextView = (TextView) findViewById(R.id.text);
        mTextViewNumCode = (TextView) findViewById(R.id.textNumCode);
        mTextViewName = (TextView) findViewById(R.id.textName);
        mTextViewValue = (TextView) findViewById(R.id.textValue);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_circular);

/*        String name = new USD().getName();
        double value = new USD().getValue();*/

        call.enqueue(new Callback<CurrencyOperations>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<CurrencyOperations> call, Response<CurrencyOperations> response) {
                mProgressBar.setVisibility(View.VISIBLE);
                USD usd = response.body().getValute().getUSD();
               // mTextView.setText(usd.getID());
               // mTextViewNumCode.setText(usd.getNumCode());
                mTextViewName.setText(usd.getName());
                mTextViewValue.setText(""+usd.getValue());
                Intent intent = new Intent(MainActivity.this, DollarActivity.class);
                intent.putExtra(USD.class.getSimpleName(), usd);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<CurrencyOperations> call, Throwable t) {
                mTextViewName.setText("Нет подключения к интернету");
            }
        });
    }
}
