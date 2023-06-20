package com.example.weatherapp

import androidx.annotation.DrawableRes

open class Data(
    val currentTemperature: Int,
    val highestTemperature: Int,
    val lowestTemperature: Int,
    val location: String,
    val condition: String,
    @DrawableRes val imageForCondition: Int
) {

    object one : Data(19, 24, 18, "Coimbatore, India", condition = "Mid Rain", getWeather("Mid Rain"))
    object two : Data(20, 21, 19, "Chennai, India", "Fast Wind", getWeather("Fast Wind"))
    object three : Data(13, 16, 8, "Tokyo, Japan", "Showers", getWeather("Showers"))
    object four : Data(12, 19, 10, "Chicago, USA", "Stormy", getWeather("Stormy"))
}

fun getWeather(condition: String): Int {
    val imageForCondition = when(condition) {
            "Mid Rain" -> R.drawable.moon_cloud_mid_rain
            "Fast Wind" -> R.drawable.moon_cloud_fast_wind
            "Showers" -> R.drawable.sun_cloud_angled_rain
            else -> R.drawable.tornado
    }
    return imageForCondition
}
