package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherapp.pages.HomePage
import com.example.weatherapp.pages.SpecificCityInfo
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val weatherData = remember {
        mutableStateListOf(
            Data(19, 24, 18, "Coimbatore, India", "Mid Rain", getWeather("Mid Rain")),
            Data(20, 21, 19, "Chennai, India", "Fast Wind", getWeather("Fast Wind")),
            Data(13, 16, 8, "Tokyo, Japan", "Showers", getWeather("Showers")),
            Data(12, 19, 10, "Chicago, USA", "Stormy", getWeather("Stormy"))
        )
    }
    val deletedItem = remember { mutableStateListOf<Data>() }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = CityRoutes.mainScreen.name) {

        composable(route = CityRoutes.mainScreen.name) {
            HomePage(
                cityInfoClickable = { navController.navigate(route = "cityInfoScreen/$it") },
                weatherData,
                deletedItem
            )
        }

        composable(
            route = "cityInfoScreen/{my_param}",
            arguments = listOf(
                navArgument("my_param") {
                    type = NavType.IntType
                }
            )
        ) {
            val param = it.arguments?.getInt("my_param") ?: 0
            SpecificCityInfo(
                param = param,
                weatherData = weatherData
            )
        }
    }
}

