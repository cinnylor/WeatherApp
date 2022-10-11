package com.example.weatherapp

data class DayForecast(
    val date: Long,
    val sunRise: Long,
    val sunSet: Long,
    val temp: ForecastTemp,
    val pressure: Float,
    val humidity: Int
)
