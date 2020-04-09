package com.semenov.jsontestl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class DollarActivity extends AppCompatActivity {

    TextView mTextView;
    Button mDollarButton;
    WebView mWebView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dollar);

        mTextView = (TextView) findViewById(R.id.dollarText);
        mWebView = (WebView) findViewById(R.id.webView);

        Bundle arguments = getIntent().getExtras();
        USD usd = arguments.getParcelable(USD.class.getSimpleName());

        mTextView.setText("Валюта: " + usd.getName() + "\nКурс: " + usd.getValue());

        mDollarButton = (Button) findViewById(R.id.dollarButton);
        mDollarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.setWebViewClient(new WebViewClient());
                mWebView.loadUrl("http://www.banki.ru/products/currency/cash/moskva/");
                WebSettings webSettings = mWebView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                mDollarButton.setVisibility(View.INVISIBLE);
                mWebView.setWebViewClient(new WebViewClient(){

                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        super.onPageStarted(view, url, favicon);
                    }

                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                    }
                });
            }

        });

    }

    @Override
    public void onBackPressed(){
        if (mWebView.canGoBack()){
            mWebView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

}
