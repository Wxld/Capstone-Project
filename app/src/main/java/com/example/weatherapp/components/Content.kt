import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.Data
import com.example.weatherapp.R
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun Content(
    cityInfoClickable: (Int)->Unit,
    weatherData: SnapshotStateList<Data>,
    deletedItem: SnapshotStateList<Data>
) {

    LazyColumn {
        itemsIndexed(weatherData){ index, card ->
            CityInfo(
                cityInfoClickable = cityInfoClickable,
                card,
                index,
                weatherData,
                deletedItem
            )
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CityInfo(
    cityInfoClickable: (Int)->Unit,
    card: Data,
    index: Int,
    weatherData: SnapshotStateList<Data>,
    deletedItem: SnapshotStateList<Data>
) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .combinedClickable (
                onClick = {
                    cityInfoClickable(index)
                },
                onLongClick = {
                    deletedItem.add(weatherData[index])
                    weatherData.removeAt(index)
                }
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.rectangle_5),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(start = 32.dp)
            ) {
                Text(
                    text = card.currentTemperature.toString(),
                    color = Color.White,
                    fontSize = 80.sp
                )
                Row {
                    Text(
                        text = "H:"+card.highestTemperature.toString(),
                        color = Color.Magenta,
                        modifier = Modifier
                            .padding(start = 12.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "L:"+card.lowestTemperature.toString(),
                        color = Color.Magenta
                    )
                }
                Text(
                    text = card.location,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 4.dp, start = 12.dp)
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = card.imageForCondition),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(7f)
                        .fillMaxSize()
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(3f)
                ) {
                    Text(
                        text = card.condition,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 40.dp),
                        color = Color.White
                    )
                }

            }
        }
    }
}

