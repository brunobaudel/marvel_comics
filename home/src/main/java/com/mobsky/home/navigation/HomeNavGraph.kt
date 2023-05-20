package com.mobsky.home.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mobsky.home.presentation.comics.ComicsScreen
import com.mobsky.home.presentation.comics.ComicsScreenViewModel
import com.mobsky.home.presentation.home.HomeScreen
import com.mobsky.home.presentation.home.HomeScreenViewModel
import com.mobsky.navigation.HomeGraph
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        route = HomeGraph.Root().rote,
        startDestination = HomeGraph.Home().rote
    ) {

        composable(route = HomeGraph.Home().rote) {
            val viewModel = koinViewModel<HomeScreenViewModel>()
            HomeScreen(viewModel) {
                val destination = when (it) {
                    else -> ""
                }
                navController.navigate(destination)
            }
        }

        composable(route = HomeGraph.Comics().rote) {
            val viewModel = koinViewModel<ComicsScreenViewModel>()
            ComicsScreen(viewModel) {
                val destination = when (it) {
                    else -> ""
                }
                navController.navigate(destination)
            }
        }
    }
}