package com.mobsky.home.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobsky.home.domain.model.HomeMenus
import com.mobsky.home.presentation.components.Gridview
import com.mobsky.home.presentation.components.MarvelTopBar
import com.mobsky.home.presentation.components.ScreenStateView
import com.mobsky.home.presentation.components.SimpleCardItem
import com.mobsky.home.presentation.util.TaskState
import com.mobsky.navigation.Navigate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, onClickNavigation: (navigate: Navigate) -> Unit) {

    Scaffold(
        topBar = {
            MarvelTopBar("Marvel Information", onClickOpenDrawer = {})
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                HomeView(viewModel, onClickNavigation)
            }
        })
}


@Composable
fun HomeView(viewModel: HomeScreenViewModel, onClickNavigation: (navigate: Navigate) -> Unit) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.taskState == TaskState.NotStarted) {
        viewModel.getMenu()
    }

    ScreenStateView(uiState,
        tryAgainCallBack = { },
        content = {
            MenuSession(uiState.homeMenus, onClickNavigation)
        }
    )
}

@Composable
fun MenuSession(homeMenus: HomeMenus, onClickNavigation: (navigate: Navigate) -> Unit) {

    val simpleCardsItems = homeMenus.map { item ->
        SimpleCardItem(
            text = item.name,
            id = item.id
        )
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Gridview(
            Modifier.padding(2.dp),
            simpleCardsItems
        ) { simpleCardsItem ->
            val itemClicked = homeMenus.find { it.id == simpleCardsItem.id }

            itemClicked?.run {
                onClickNavigation.invoke(route)
            }

        }
    }
}

