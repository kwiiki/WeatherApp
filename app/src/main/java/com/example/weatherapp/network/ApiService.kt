package com.example.weatherapp.network

import android.provider.CalendarContract.CalendarAlerts
import com.example.weatherapp.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/forecast.json")
    suspend fun getLocation(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days:Int,
        @Query("aqi") aqi: String,
        @Query("alerts") alerts: String
    ): WeatherData
}
