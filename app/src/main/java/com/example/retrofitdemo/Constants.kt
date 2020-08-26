package com.example.retrofitdemo

class Constants{
    companion object{
        const val BASE_URL="https://earthquake.usgs.gov/fdsnws/event/1/"
       // https://earthquake.usgs.gov/fdsnws/event/1/[METHOD[?PARAMETERS]]
        //@GET("fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10")
    }
}