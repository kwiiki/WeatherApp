package com.example.weatherapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.data.DAO.DayDao
import com.example.weatherapp.data.DAO.ForecastDao
import com.example.weatherapp.data.DAO.ForecastDayDao
import com.example.weatherapp.data.DAO.ConditionDao
import com.example.weatherapp.data.DAO.CurrentDao
import com.example.weatherapp.data.DAO.LocationDao

@Database(entities = [LocationEntity::class, CurrentEntity::class, ConditionEntity::class, ForecastEntity::class, ForecastDayEntity::class, DayEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
    abstract fun currentDao(): CurrentDao
    abstract fun conditionDao(): ConditionDao
//    abstract fun forecastDao(): ForecastDao
//    abstract fun forecastDayDao(): ForecastDayDao
//    abstract fun dayDao(): DayDao

//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
}

