package com.mobsky.home.presentation.characters

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.mobsky.home.presentation.components.CharactersListView
import com.mobsky.home.presentation.components.MarvelTopBar
import com.mobsky.home.presentation.components.ScreenStateView
import com.mobsky.home.presentation.util.TaskState
import com.mobsky.navigation.Navigate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen(
    viewModel: CharactersScreenViewModel,
    onClickNavigation: (navigate: Navigate) -> Unit
) {
    Scaffold(
        topBar = {
            MarvelTopBar("Characters", onClickOpenDrawer = {})
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                CharactersView(viewModel, onClickNavigation)
            }
        })
}

@Composable
fun CharactersView(viewModel: CharactersScreenViewModel, onClickNavigation: (navigate: Navigate) -> Unit) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.taskState == TaskState.NotStarted) {
        viewModel.getCharacters()
    }

    ScreenStateView(uiState,
        tryAgainCallBack = { },
        content = {
            Column {
                CharactersListView(uiState.Characters, onItemClick = {comic->
                })
            }
        }
    )
}
