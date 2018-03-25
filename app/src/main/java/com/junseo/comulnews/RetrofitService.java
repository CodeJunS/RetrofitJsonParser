package com.junseo.comulnews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by junse on 2018-03-26.
 */

public interface RetrofitService {

    @GET("comul.json")
    Call<RetrofitRepo> getIndex(
            @Query("title") String title
    );
}
