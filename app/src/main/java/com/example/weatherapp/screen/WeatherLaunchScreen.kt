package com.example.weatherapp.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.example.weatherapp.R
import kotlinx.coroutines.delay


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherLaunchScreen(navigateToWeatherScreen: () -> Unit) {
    val img = painterResource(id = R.drawable.group)

    LaunchedEffect(Unit) {

//
        delay(6000)

        navigateToWeatherScreen()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xff282E5E), Color(0xff8849AD)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = img,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 100.dp)
                .size(250.dp)
        )
        Text(
            text = "Welcome to WetheApp",
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            color = Color(0xffDDB130)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun PreviewWeatherLaunchScreen() {
}