package com.semenov.jsontestl;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("/daily_json.js")
    Call<CurrencyOperations> getMyJSON();
}
