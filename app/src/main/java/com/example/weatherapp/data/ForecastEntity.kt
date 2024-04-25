package com.example.weatherapp.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "forecasts")
data class ForecastEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)

@Entity(
    tableName = "forecast_days",
    foreignKeys = [
        ForeignKey(
            entity = ForecastEntity::class,
            parentColumns = ["id"],
            childColumns = ["forecastId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DayEntity::class,
            parentColumns = ["id"],
            childColumns = ["dayId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ForecastDayEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String,
    val forecastId: Int,
    val dayId: Long
)