package com.example.weatherapp.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.weatherapp.data.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(locationEntity: LocationEntity)

    @Update
     fun update(locationEntity: LocationEntity)

    @Query("SELECT * FROM locations")
     fun getLocation(): Flow<List<LocationEntity>>

    @Delete
     fun delete(locationEntity: LocationEntity)
}