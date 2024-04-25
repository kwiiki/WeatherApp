package com.example.weatherapp.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.LocationEntity
import com.example.weatherapp.model.ForecastDay
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.network.ApiService
import com.example.weatherapp.repository.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class WeatherViewModel : ViewModel(),KoinComponent {

    private val repository:LocationRepository by inject()

    private val _weatherData = MutableStateFlow<WeatherData?>(null)
    val weatherData: StateFlow<WeatherData?> = _weatherData
    var listOfDay:List<ForecastDay> = mutableListOf()


    init {
        getWeatherData()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getWeatherData() {
        viewModelScope.launch {

            try {
                val response = RetrofitInstance.api.getLocation(
                    apiKey = "65f1cc3c87004195a94174120241604",
                    location = "London",
                    days = 5,
                    aqi = "no",
                    alerts = "no"

                )
                Log.d("www", "getLocation: ${response}")
                _weatherData.value = response


//                 repository.addLocation(LocationEntity(1,"London","London","British"))
//                Log.d("www2", "getLocation: ${repository.getLocation()}")
                listOfDay = convertDatesToWeekdays(response.forecast.forecastday)
                Log.d("w1","list: $listOfDay ")

            } catch (e: Exception) {
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
fun convertDatesToWeekdays(forecastDays: List<ForecastDay>): List<ForecastDay> {
    val weekdays = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    return forecastDays.map { forecastDay ->
        val date = LocalDate.parse(forecastDay.date, formatter)
        val weekdayIndex = date.dayOfWeek.value % 7
        forecastDay.copy(date = weekdays[weekdayIndex])
    }
}
object RetrofitInstance {
    const val BASE_URL = "https://api.weatherapi.com/"
    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}