package com.mobsky.home.domain.model

typealias HomeMenus = List<HomeMenu>

data class HomeMenu(
    val id: String,
    val name: String,
    val isActive: Boolean
)
