package com.mobsky.home.data.network.api.model.comics


import com.google.gson.annotations.SerializedName

data class UrlResponse(
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = ""
)