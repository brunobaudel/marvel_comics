package com.mobsky.home.data.network.api.model.characters


import com.google.gson.annotations.SerializedName

data class StoriesResponse(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<ItemResponseXXX>? = listOf(),
    @SerializedName("returned")
    val returned: Int? = 0
)