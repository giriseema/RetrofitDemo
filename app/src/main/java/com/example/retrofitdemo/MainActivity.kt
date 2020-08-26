package com.example.retrofitdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdemo.Constants.Companion.BASE_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
 val TAG="MainActivity";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /* GlobalScope .launch(Dispatchers.IO) {
            val answer=RetrofitInstance.api.getResultData()
            withContext(Dispatchers.Main){
                Log.d(TAG, answer.toString())
            }
        }*/


        val api= Retrofit.Builder().
            baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EarthQuakeService::class.java)

        GlobalScope.launch(Dispatchers.IO){
            val answer=async { api.getResultData()}
            Log.i(TAG, "${answer.await()}")
        }
/*
          api.getResultData().enqueue(object : Callback<EarthQuakeResponse> {
              override fun onFailure(call: Call<EarthQuakeResponse>?, t: Throwable?) {
                  Log.i(TAG,"$t")
              }

              override fun onResponse(
                  call: Call<EarthQuakeResponse>?,
                  response: Response<EarthQuakeResponse>?
              ) {
                  if(response?.isSuccessful!!){
                      Log.i(TAG,response.body().toString())
                  }
              }
          })*/


    }

}