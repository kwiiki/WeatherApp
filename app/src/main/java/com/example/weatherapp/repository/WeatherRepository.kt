//package com.example.weatherapp.repository
//
//import android.content.Context
//import com.example.weatherapp.data.AppDatabase
//import com.example.weatherapp.data.ConditionEntity
//import com.example.weatherapp.data.CurrentEntity
//import com.example.weatherapp.data.DayEntity
//import com.example.weatherapp.data.ForecastDayEntity
//import com.example.weatherapp.data.ForecastEntity
//import com.example.weatherapp.data.LocationEntity
//import com.example.weatherapp.model.WeatherData
//
//class WeatherRepository(context: Context) {
//
//    private val database = AppDatabase.getInstance(context)
//
//    suspend fun insertWeatherData(weatherData: WeatherData) {
//        val locationEntity = LocationEntity(
//            name = weatherData.location.name,
//            region = weatherData.location.region,
//            country = weatherData.location.country
//        )
//        database.locationDao().insert(locationEntity)
//
//        val conditionEntity = ConditionEntity(
//            text = weatherData.current.condition.text,
//            icon = weatherData.current.condition.icon
//        )
//        val conditionId = database.conditionDao().insert(conditionEntity)
//
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
//        val forecastEntity = ForecastEntity()
//        val forecastId = database.forecastDao().insert(forecastEntity)
//
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
//                dayId = dayId.toLong()
//            )
//            database.forecastDayDao().insert(forecastDayEntity)
//        }
//    }
//
//
//    // DELETE
//    suspend fun deleteWeatherData(context: Context) {
//        val database = AppDatabase.getInstance(context)
//
//        database.forecastDayDao().deleteAll()
//        database.dayDao().deleteAll()
//        database.forecastDao().deleteAll()
//        database.currentDao().deleteAll()
//        database.conditionDao().deleteAll()
//        database.locationDao().deleteAll()
//    }
//
//
//    // UPDATE
//    suspend fun updateWeatherData(weatherData: WeatherData, context: Context) {
//        val database = AppDatabase.getInstance(context)
//
//        val locationEntity = LocationEntity(
//            name = weatherData.location.name,
//            region = weatherData.location.region,
//            country = weatherData.location.country
//        )
//        database.locationDao().update(locationEntity)
//
//        val conditionEntity = ConditionEntity(
//            text = weatherData.current.condition.text,
//            icon = weatherData.current.condition.icon
//        )
//        database.conditionDao().update(conditionEntity)
//
//        val currentEntity = CurrentEntity(
//            temp_c = weatherData.current.temp_c,
//            isDay = weatherData.current.isDay,
//            conditionId = conditionEntity.id,
//            humidity = weatherData.current.humidity,
//            cloud = weatherData.current.cloud,
//            last_updated = weatherData.current.last_updated
//        )
//        database.currentDao().update(currentEntity)
//
//        val forecastEntity = database.forecastDao().getForecast()
//        if (forecastEntity != null) {
//            database.forecastDayDao().deleteForForecast(forecastEntity.id)
//            database.dayDao().deleteForForecastDays(forecastEntity.id)
//
//            weatherData.forecast.forecastday.forEach { forecastDay ->
//                val dayEntity = DayEntity(
//                    maxtemp_c = forecastDay.day.maxtemp_c,
//                    mintemp_c = forecastDay.day.mintemp_c,
//                    conditionId = conditionEntity.id
//                )
//                val dayId = database.dayDao().insert(dayEntity)
//
//                val forecastDayEntity = ForecastDayEntity(
//                    date = forecastDay.date,
//                    forecastId = forecastEntity.id,
//                    dayId = dayId
//                )
//                database.forecastDayDao().insert(forecastDayEntity)
//            }
//        }
//    }
//
//    suspend fun getWeatherData( context: Context){
//        val database = AppDatabase.getInstance(context)
//
//    }
//
//
//}