package com.mobsky.home.domain.usecase

import com.mobsky.home.domain.model.HomeMenu
import com.mobsky.home.domain.model.HomeMenus

class GetHomeMenuUseCase() : UseCase<HomeMenus, Unit>() {

    override suspend fun run(params: Unit): HomeMenus = let {
        listOf(HomeMenu(id = "" , name= "Characters", isActive = true))
    }
}