import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun Content(
    cards: List<Weather>
) {
    Column() {
        cards.forEach{card ->
            CityInfo(card)
        }
    }
}


@Composable
fun CityInfo(card: Weather) {

}