package com.example.retrofitdemo

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EarthQuakeService {

    @GET("query")
    fun getResultData(@Query("format")
                      formatType: String = "geojson",
                      @Query("eventtype")
                      eventType: String = "earthquake",
                      @Query("orderby")
                      orderBy: String = "time",
                      @Query("minmag")
                      minmag: Int = 6,
                      @Query("limit")
                      limit: Int = 10 ): Call<EarthQuakeResponse>
}
