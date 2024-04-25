package com.example.weatherapp.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.ForecastDayEntity

@Dao
interface ForecastDayDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(forecastDayEntity: ForecastDayEntity)

    @Query("DELETE FROM forecast_days WHERE forecastId = :forecastId")
    suspend fun deleteForForecast(forecastId: Int)

    @Query("DELETE FROM forecast_days")
    suspend fun deleteAll()
}