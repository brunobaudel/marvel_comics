package com.mobsky.home.domain.usecase

import com.mobsky.home.domain.model.HomeMenu
import com.mobsky.home.domain.model.HomeMenus
import com.mobsky.navigation.HomeGraph

class GetHomeMenuUseCase() : UseCase<HomeMenus, Unit>() {

    override suspend fun run(params: Unit): HomeMenus =
        listOf(
            HomeMenu(id = 1, name = "Characters", route = HomeGraph.Characters(), isActive = false),
            HomeMenu(id = 2, name = "Comics", route = HomeGraph.Comics(), isActive = true),
            HomeMenu(id = 3, name = "Creators", route = HomeGraph.Creators(), isActive = false),
        ).filter { it.isActive }

}