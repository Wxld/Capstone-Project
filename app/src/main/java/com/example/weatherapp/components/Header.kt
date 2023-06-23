package com.example.weatherapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun Header(
    weatherData: SnapshotStateList<Data>,
    deletedItem: SnapshotStateList<Data>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.header),
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier
                .padding(start = 12.dp)
        )
        TextButton(
            onClick = {
                for (item in deletedItem) {
                    weatherData.add(item)
                }
                deletedItem.clear()
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable._right_title),
                contentDescription = stringResource(id = R.string.settings),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(32.dp)
            )
        }
    }
}
