package com.example.weatherapp.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.weatherapp.data.ConditionEntity

@Dao
interface ConditionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(conditionEntity: ConditionEntity): Long

    @Update
    suspend fun update(conditionEntity: ConditionEntity)

    @Query("DELETE FROM conditions")
    suspend fun deleteAll()
}