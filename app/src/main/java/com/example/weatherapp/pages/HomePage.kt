package com.example.weatherapp.pages

import Content
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.weatherapp.Data
import com.example.weatherapp.R
import com.example.weatherapp.components.Header
import com.example.weatherapp.components.SearchBar

@Composable
fun HomePage(
    cityInfoClickable: (Int)->Unit,
    weatherData: SnapshotStateList<Data>,
    deletedItem: SnapshotStateList<Data>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(colorResource(R.color.purple_primary))
    ) {
        Header(
            weatherData,
            deletedItem
        )
        SearchBar()
        Content(
            cityInfoClickable = cityInfoClickable,
            weatherData,
            deletedItem
        )
    }
}



