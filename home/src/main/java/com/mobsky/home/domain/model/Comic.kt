package com.mobsky.home.domain.model

typealias Comics = List<Comic>

data class Comic(
    val title: String = "",
    val description: String = "",
    val imageUrl: String = ""
)
