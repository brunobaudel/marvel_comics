package com.mobsky.home.data.network.api.model.characters


import com.google.gson.annotations.SerializedName

data class UrlResponse(
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = ""
)