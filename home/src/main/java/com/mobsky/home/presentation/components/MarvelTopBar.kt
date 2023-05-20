package com.mobsky.home.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarvelTopBar(topBarName: String, onClickOpenDrawer: () -> Unit) {

    Surface(shadowElevation = 4.dp) {
        TopAppBar(title = { Text(text = topBarName) },
            navigationIcon = {
                IconButton(onClick = { onClickOpenDrawer() }) {
                    Icon(Icons.Filled.Menu, "")
                }
            }
        )
    }
}
