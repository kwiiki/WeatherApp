package com.example.weatherapp.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.model.ForecastDay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val weatherData by viewModel.weatherData.collectAsState()
    val font = FontFamily(Font(R.font.calistoga))
    val robotoBolt = FontFamily(Font(R.font.rbold))
    val robotoRegular = FontFamily(Font(R.font.rregular))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xfff1b14b), Color(0xffbc2c35)
                    )
                )
            )
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        val listOfDay = viewModel.listOfDay
        Column(
            modifier = Modifier.padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = weatherData?.location?.name ?: "",
                fontSize = 36.sp,
                color = Color.White,
                fontFamily = font
            )
            Text(
                text = weatherData?.current?.condition?.text ?: "",
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = robotoRegular
            )

            AsyncImage(
                model = "https:${weatherData?.current?.condition?.icon}",
                contentDescription = "",
                modifier = Modifier.size(160.dp)
            )

            Text(
                text = weatherData?.current?.temp_c?.toInt().toString(),
                fontSize = 72.sp,
                fontFamily = robotoBolt,
                color = Color.White
            )
            weatherData?.current?.last_updated?.let { lastUpdated ->
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH)
                val dateTime = LocalDateTime.parse(lastUpdated, formatter)
                val outputFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)
                val formattedDate = dateTime.format(outputFormat)
                Text(
                    text = formattedDate.toString(),
                    fontSize = 22.sp,
                    fontFamily = robotoRegular,
                    color = Color.White
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {

            val listOfDay = viewModel.listOfDay
            Log.d("w11", "WeatherScreen: $listOfDay")
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(listOfDay) { day ->
                    Row(Modifier.fillMaxWidth()) {
                        WeatherItem(
                            day = day,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
                        )
                    }


                }
            }

        }
    }
}


@Composable
fun WeatherItem(day: ForecastDay, modifier: Modifier) {
    val robotoRegular = FontFamily(Font(R.font.rregular))
    val img = painterResource(id = R.drawable.cloud1)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = day.date,
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = robotoRegular,
            modifier = Modifier.width(110.dp)
        )

//        Spacer(modifier = Modifier.width(10.dp))

        AsyncImage(
            model = "https:${day.day.condition.icon}",
            contentDescription = null,
            modifier = Modifier.size(45.dp)
        )


//        Spacer(modifier = Modifier.width(30.dp)

        Text(
            text = day.day.maxtemp_c.toInt().toString(),
            fontSize = 24.sp,
            color = Color.White,
            fontFamily = robotoRegular
        )

//        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = day.day.mintemp_c.toInt().toString(),
            fontSize = 24.sp,
            color = Color(0xffA8A8A8),
            fontFamily = robotoRegular
        )


    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun WeatherScreenPreview() {
    val viewModel = viewModel<WeatherViewModel>()
    WeatherScreen(viewModel = viewModel)
//    WeatherItem(day = viewModel.listOfDay[0], modifier = Modifier)
}