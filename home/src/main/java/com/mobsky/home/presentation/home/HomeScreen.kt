package com.mobsky.home.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobsky.home.domain.model.HomeMenu
import com.mobsky.home.domain.model.HomeMenus
import com.mobsky.home.presentation.components.Gridview
import com.mobsky.home.presentation.components.MarvelTopBar
import com.mobsky.home.presentation.components.ScreenStateView
import com.mobsky.home.presentation.components.SimpleCardItem
import com.mobsky.home.presentation.util.TaskState
import com.mobsky.navigation.HomeGraph
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
fun MenuSession(homeMenus: HomeMenus, onClickNavigation: (navigate: Navigate) -> Unit = {}) {

    val simpleCardsItems = homeMenus.map { item ->
        SimpleCardItem(
            text = item.name,
            id = item.id
        )
    }

    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Gridview(
            Modifier.padding(top = 12.dp),
            simpleCardsItems
        ) { simpleCardsItem ->
            homeMenus.find { it.id == simpleCardsItem.id }?.run {
                onClickNavigation.invoke(route)
            }
        }
    }
}

@Preview
@Composable
fun MenuSession() {

    MenuSession(
        listOf(
            HomeMenu(
                id = 1,
                name = "Item 1",
                route = HomeGraph.Home(),
                isActive = false
            ),
            HomeMenu(
                id = 1,
                name = "Item 2",
                route = HomeGraph.Home(),
                isActive = false
            ),
            HomeMenu(
                id = 1,
                name = "Item 3",
                route = HomeGraph.Home(),
                isActive = false
            ),
            HomeMenu(
                id = 1,
                name = "Item 4",
                route = HomeGraph.Home(),
                isActive = false
            ),
            HomeMenu(
                id = 1,
                name = "Item 5",
                route = HomeGraph.Home(),
                isActive = false
            )
        )
    )

}
