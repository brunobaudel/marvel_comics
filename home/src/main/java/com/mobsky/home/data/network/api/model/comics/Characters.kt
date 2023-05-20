package com.mobsky.home.data.network.api.model.comics


import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<Any?>? = listOf(),
    @SerializedName("returned")
    val returned: Int? = 0
)