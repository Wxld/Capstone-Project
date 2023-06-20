package com.example.weatherapp

import Content
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.weatherapp.components.Header
import com.example.weatherapp.components.SearchBar

@Composable
fun HomePage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header()
        SearchBar()
        Content()
    }
}



