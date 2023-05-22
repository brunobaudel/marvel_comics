package com.mobsky.home.data.network.api.model.characters


import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = ""
)