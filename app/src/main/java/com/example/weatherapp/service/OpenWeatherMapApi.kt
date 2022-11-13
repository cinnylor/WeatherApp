package com.example.weatherapp.service


import com.example.weatherapp.models.CurrentConditions
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {
    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey : String = "1c2b1bb8a7bbde56bc4294eb3cca94c5 ",
        @Query("units") units: String = "imperial"
    ) : CurrentConditions
}