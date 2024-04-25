package com.example.weatherapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "days")
data class DayEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val conditionId: Int // Foreign key to ConditionEntity
)