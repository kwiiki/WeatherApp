package com.example.weatherapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current")
data class CurrentEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val temp_c: Double,
    val isDay: Int,
    val conditionId: Int, // Foreign key to ConditionEntity
    val humidity: Int,
    val cloud: Int,
    val last_updated: String
)
