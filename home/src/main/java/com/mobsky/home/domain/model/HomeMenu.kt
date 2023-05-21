package com.mobsky.home.domain.model

import com.mobsky.navigation.Navigate

typealias HomeMenus = List<HomeMenu>

data class HomeMenu(
    val id: Int,
    val name: String,
    val route: Navigate,
    val isActive: Boolean
)
