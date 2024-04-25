package com.example.weatherapp.di

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.example.weatherapp.data.AppDatabase
import com.example.weatherapp.network.ApiService
import com.example.weatherapp.repository.LocationRepository
import com.example.weatherapp.repository.LocationRepositoryImpl
import org.koin.core.context.startKoin
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KoinStart: Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(databaseModule,repositoryModule,retrofitModule,apiModule)
        }
    }
    private val databaseModule = module {
        single {
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "app_database1"
            )
                .build()
        }
    }
    private val repositoryModule = module {
        single<LocationRepository> {
            LocationRepositoryImpl(appDatabase  = get())
        }
    }
    private val retrofitModule = module {
        single { retrofitBuilder() }
    }
    private fun Scope.retrofitBuilder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create()) krn sudah pakai --> Coroutines
            .client(get())
            .build()
    }
//    @RequiresApi(Build.VERSION_CODES.O)
//    val viewModelModule = module {
//        viewModel { WeatherViewModel(get<Retrofit>() )}
//    }
    private val apiModule = module {
        single<ApiService> {
            get<Retrofit>().create(ApiService::class.java)
        }
    }
}