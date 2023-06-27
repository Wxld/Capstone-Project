package com.example.weatherapp

import androidx.annotation.DrawableRes

data class Data(
    val currentTemperature: Int,
    val highestTemperature: Int,
    val lowestTemperature: Int,
    val location: String,
    val condition: String,
    @DrawableRes val imageForCondition: Int
)

@DrawableRes fun getWeather(condition: String): Int {
    @DrawableRes val imageForCondition = when(condition) {
            "Mid Rain" -> R.drawable.moon_cloud_mid_rain
            "Fast Wind" -> R.drawable.moon_cloud_fast_wind
            "Showers" -> R.drawable.sun_cloud_angled_rain
            else -> R.drawable.tornado
    }
    return imageForCondition
}

