package com.semenov.jsontestl;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("/daily_json.js")
    Call<CurrencyOperations> getMyJSON();
   // Call<CurrencyOperations> getData(@Query("ID") String resourceName);
    //getMyJSON();
}
