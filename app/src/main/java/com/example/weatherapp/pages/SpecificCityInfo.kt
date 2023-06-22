package com.example.weatherapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.Data
import com.example.weatherapp.R

@Composable
fun SpecificCityInfo(
    weatherData: SnapshotStateList<Data>,
    param: Int
) {
    val neg = 4
    val cityInfo = weatherData[param]
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.wallpaper),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = cityInfo.location,
                    color = Color.White,
                    fontSize = 36.sp,
                    modifier = Modifier
                        .offset(y = 24.dp)
                )
                Text(
                    text = cityInfo.currentTemperature.toString(),
                    color = Color.White,
                    fontSize = 100.sp,
                    modifier = Modifier
                        .offset(y = 12.dp)
                )
                Text(
                    text = stringResource(R.string.mostly_clear),
                    color = Color.Gray,
                    fontSize = 20.sp
                )
                Row() {
                    Text(
                        text = "H:"+cityInfo.highestTemperature.toString(),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "L:"+cityInfo.lowestTemperature.toString(),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(3f)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.wallpaper_house),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

        }
    }
}