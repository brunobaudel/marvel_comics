package com.mobsky.home.di

import com.mobsky.home.presentation.comics.ComicsScreenViewModel
import com.mobsky.home.presentation.home.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val homeViewModelModules = module {

    viewModel { HomeScreenViewModel(getHomeMenuUseCase = get()) }

    viewModel { ComicsScreenViewModel(getComicsUseCase = get()) }

}
