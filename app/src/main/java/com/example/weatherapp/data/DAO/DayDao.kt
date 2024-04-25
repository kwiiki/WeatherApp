package com.example.weatherapp.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.DayEntity

@Dao
interface DayDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dayEntity: DayEntity): Long

    @Query("DELETE FROM days WHERE id IN (SELECT dayId FROM forecast_days WHERE forecastId = :forecastId)")
    suspend fun deleteForForecastDays(forecastId: Int)

    @Query("DELETE FROM days")
    suspend fun deleteAll()
}