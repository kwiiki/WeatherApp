package com.example.weatherapp.repository

import com.example.weatherapp.data.AppDatabase
import com.example.weatherapp.data.LocationEntity
import kotlinx.coroutines.flow.Flow

class LocationRepositoryImpl(appDatabase: AppDatabase):LocationRepository {
    private val dao = appDatabase.locationDao()

    override suspend fun getLocation(): Flow<List<LocationEntity>> = dao.getLocation()

    override suspend fun addLocation(locationEntity: LocationEntity) = dao.insert(locationEntity)

    override suspend fun updateLocation(locationEntity: LocationEntity) = dao.update(locationEntity)

    override suspend fun deleteLocation(locationEntity: LocationEntity) = dao.delete(locationEntity)
}