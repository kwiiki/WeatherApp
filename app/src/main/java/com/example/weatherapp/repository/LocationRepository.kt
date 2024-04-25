package com.example.weatherapp.repository

import com.example.weatherapp.data.LocationEntity
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun getLocation():Flow<List<LocationEntity>>
    suspend fun addLocation(locationEntity: LocationEntity)
    suspend fun updateLocation(locationEntity: LocationEntity)
    suspend fun deleteLocation(locationEntity: LocationEntity)
}