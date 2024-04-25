package com.example.weatherapp.model

import com.example.weatherapp.data.LocationEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class WeatherData(
    val location: LocationEntity,
    val current: Current,
    val forecast: Forecast,
)

//@JsonClass(generateAdapter = true)
//data class Location(
//    val name: String,
//    val region: String,
//    val country: String,
//)

@JsonClass(generateAdapter = true)
data class Current(
    @Json(name = "temp_c") val temp_c: Double,
    @Json(name = "is_day") val isDay: Int,
    val condition: Condition,
    val humidity: Int,
    val cloud: Int,
    val last_updated: String,
)

@JsonClass(generateAdapter = true)
data class Condition(
    val text: String,
    val icon: String,
)

@JsonClass(generateAdapter = true)
data class Forecast(
    @Json(name = "forecastday") val forecastday: List<ForecastDay>
)

@JsonClass(generateAdapter = true)
data class ForecastDay(
    val date: String,
    val day: Day,
)

@JsonClass(generateAdapter = true)
data class Day(
   val maxtemp_c: Double,
   val mintemp_c: Double,
    val condition: Condition,
)