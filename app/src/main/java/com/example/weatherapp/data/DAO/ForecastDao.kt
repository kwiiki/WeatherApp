package com.example.weatherapp.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.ForecastEntity

@Dao
interface ForecastDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(forecastEntity: ForecastEntity): Long

    @Query("SELECT * FROM forecasts LIMIT 1")
    suspend fun getForecast(): ForecastEntity?

    @Query("DELETE FROM forecasts")
    suspend fun deleteAll()
}