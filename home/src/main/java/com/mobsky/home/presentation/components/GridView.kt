package com.mobsky.home.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

    LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.fillMaxHeight()
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
        shape = MaterialTheme.shapes.medium
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .background(Color.LightGray)
                .clickable { action() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center,
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
                SimpleCardItem("teste1", 1),
                SimpleCardItem("teste teste2", 1),
                SimpleCardItem("teste3", 1),
                SimpleCardItem("teste4", 1),
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