package com.example.weatherapp
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.network.ApiService
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.screen.WeatherScreen
import com.example.weatherapp.screen.WeatherViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// val key = BuildConfig.KEY
        setContent {
//            var navigateToWeatherScreen by remember { mutableStateOf(false) }
//
//            if (navigateToWeatherScreen) {
//                WeatherScreen(viewModel = viewModel<WeatherViewModel>())
//            } else {
//                WeatherLaunchScreen {
//                    navigateToWeatherScreen = true
//                }
//            }

            val viewModel = viewModel<WeatherViewModel>()
            WeatherScreen(viewModel)

        }

    }
}


//    private suspend fun getPosts(apiService: ApiService) {
//        try {
//            val response = apiService.getLocation(
//                apiKey = "65f1cc3c87004195a94174120241604",
//                location = "London",
//                days = 1,
//                aqi = "no",
//                alerts = "no"
//
//            )
//            Log.d("www", "getPosts: ${response}")
//        } catch (e: Exception) {
//            // Handle errors here
//        }
//    }
//}

//@Composable
//fun Greeting(weatherData: WeatherData,modifier: Modifier) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                brush = Brush.horizontalGradient(
//                    colors = listOf(
//                        Color(0xfff1b14b),
//                        Color(0xffbc2c35)
//                    )
//                )
//            ),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//
//        Column(modifier = Modifier) {
//            Text(text = weatherData.location.country )
//
//        }
//
//
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppTheme {
//        Greeting()
    }
}

object RetrofitInstance {
    private
    const val BASE_URL = "https://api.weatherapi.com/"
    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}
