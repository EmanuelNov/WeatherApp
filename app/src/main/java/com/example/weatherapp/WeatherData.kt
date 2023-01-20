package com.example.weatherapp

data class WeatherData(
    val condition: Int,
    val temp: Int,
    val tempMax: Int,
    val tempMin: Int,
    val wind: Int,
    val humidity: Int,
    val precipitation: Int
    )