package com.example.weatherapp.components

import android.provider.Settings.Global.getString
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.App
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.header),
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp)
        )
        TextButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable._right_title),
                contentDescription = stringResource(id = R.string.settings),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(50.dp)
            )
        }
    }
}
