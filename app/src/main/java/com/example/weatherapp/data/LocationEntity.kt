package com.example.weatherapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
//    @ColumnInfo("name")
    val name: String,
//    @ColumnInfo("region")
    val region: String,
//    @ColumnInfo("country")
    val country: String
)
