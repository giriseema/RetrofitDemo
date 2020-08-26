package com.example.retrofitdemo

data class EarthQuakeResponse(
    val bbox: List<Double>,
    val features: List<Feature>,
    val metadata: Metadata,
    val type: String
)