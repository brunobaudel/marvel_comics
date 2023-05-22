package com.mobsky.home.domain.model

typealias Characters = List<Character>

data class Character(
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val pageCount: Int = 0
)