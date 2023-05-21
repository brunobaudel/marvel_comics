package com.mobsky.home.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobsky.navigation.Navigate

data class SimpleCardItem(
    val text: String,
    val id: Int
)

@Composable
fun Gridview(
    modifier: Modifier = Modifier,
    gridViewData: List<SimpleCardItem> = emptyList(),
    onClickNavigation: (SimpleCardItem) -> Unit = {}
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ) {
        items(gridViewData) { gridItem ->
            SimpleCard(
                text = gridItem.text,
                modifier = Modifier.height(32.dp)
            ) {
                onClickNavigation.invoke(gridItem)
            }
        }
    }
}

@Composable
fun SimpleCard(
    text: String,
    modifier: Modifier = Modifier,
    action: () -> Unit = {}
) {
    Surface(
        shape = MaterialTheme.shapes.small, // ARREDONDA AS BORDAS
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.LightGray)
                .clickable { action() }
        ) {
//            Image(
//                painter = painterResource(drawable),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.size(56.dp)
//            )
            Text(
                text = text,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun GridviewPreview() {
    MaterialTheme {
        Gridview(
            gridViewData = listOf(
                SimpleCardItem("teste", 1),
                SimpleCardItem("teste teste", 1),
                SimpleCardItem("teste", 1),
                SimpleCardItem("teste", 1),
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SimpleCardPreview() {
    MaterialTheme {
        SimpleCard(
            text = "teste",
            modifier = Modifier.padding(8.dp)
        )
    }
}