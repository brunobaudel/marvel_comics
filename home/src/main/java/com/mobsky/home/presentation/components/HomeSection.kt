package com.mobsky.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        if (title.isNotBlank())
            Text(modifier = Modifier.padding(top = 8.dp, start = 12.dp), text = title)
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    HomeSection("") {
        ProfileRow(
            rowData = listOf(
                ProfileImageItem(
                    com.google.android.material.R.drawable.ic_arrow_back_black_24,
                    ""
                ),
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}
