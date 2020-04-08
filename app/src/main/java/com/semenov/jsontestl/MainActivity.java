package com.semenov.jsontestl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private CurrencyOperations operations;
    private ArrayList<CurrencyOperations> mList;

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
               // getData("bash");

        mTextView = (TextView) findViewById(R.id.text);
       // final CurrencyOperations operations = new CurrencyOperations();
      //  this.operations = new CurrencyOperations();
       // final USD usd = new USD();

/*        HashMap<String, Object> hm;
        hm = new HashMap<String, Object>();
        //читаем что в себе хранит параметр balance
        hm.put(NAME, urls.getJSONObject(i).getString("name").toString());*/

        call.enqueue(new Callback<CurrencyOperations>() {
            @Override
            public void onResponse(Call<CurrencyOperations> call, Response<CurrencyOperations> response) {
                USD usd = response.body().getValute().getUSD();
                mTextView.setText(usd.getID()); // ???
            }

            @Override
            public void onFailure(Call<CurrencyOperations> call, Throwable t) {

            }
        });
    }
}
