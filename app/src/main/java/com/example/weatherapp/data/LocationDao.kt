//package com.example.weatherapp.data
//
//import android.content.Context
//import com.example.weatherapp.model.WeatherData
//
//
//class LocationDao(private val context: Context) {
//    suspend fun insertWeatherData(weatherData: WeatherData) {
//        val database = AppDatabase.getInstance(context)
//
//        // Insert location
//        val locationEntity = LocationEntity(
//            name = weatherData.location.name,
//            region = weatherData.location.region,
//            country = weatherData.location.country
//        )
//        database.locationDao().insert(locationEntity)
//
//        // Insert condition
//        val conditionEntity = ConditionEntity(
//            text = weatherData.current.condition.text,
//            icon = weatherData.current.condition.icon
//        )
//        val conditionId = database.conditionDao().insert(conditionEntity)
//
//        // Insert current
//        val currentEntity = CurrentEntity(
//            temp_c = weatherData.current.temp_c,
//            isDay = weatherData.current.isDay,
//            conditionId = conditionId.toInt(),
//            humidity = weatherData.current.humidity,
//            cloud = weatherData.current.cloud,
//            last_updated = weatherData.current.last_updated
//        )
//        database.currentDao().insert(currentEntity)
//
//        // Insert forecast
//        val forecastEntity = ForecastEntity()
//        val forecastId = database.forecastDao().insert(forecastEntity)
//
//        // Insert forecast days and days
//        weatherData.forecast.forecastday.forEach { forecastDay ->
//            val dayEntity = DayEntity(
//                maxtemp_c = forecastDay.day.maxtemp_c,
//                mintemp_c = forecastDay.day.mintemp_c,
//                conditionId = conditionId.toInt()
//            )
//            val dayId = database.dayDao().insert(dayEntity)
//
//            val forecastDayEntity = ForecastDayEntity(
//                date = forecastDay.date,
//                forecastId = forecastId.toInt(),
//                dayId = dayId.toInt()
//            )
//            database.forecastDayDao().insert(forecastDayEntity)
//        }
//    }
//}