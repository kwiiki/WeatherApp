package com.example.weatherapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conditions")
data class ConditionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val icon: String
)