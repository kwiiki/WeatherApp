package com.example.weatherapp.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.weatherapp.data.CurrentEntity

@Dao
interface CurrentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currentEntity: CurrentEntity)

    @Update
    suspend fun update(currentEntity: CurrentEntity)

    @Query("DELETE FROM current")
    suspend fun deleteAll()
}