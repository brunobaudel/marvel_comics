package com.mobsky.home.data.network.api.model.characters


import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<ItemResponse>? = listOf(),
    @SerializedName("returned")
    val returned: Int? = 0
)