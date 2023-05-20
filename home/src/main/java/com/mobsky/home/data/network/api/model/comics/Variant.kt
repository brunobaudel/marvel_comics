package com.mobsky.home.data.network.api.model.comics


import com.google.gson.annotations.SerializedName

data class Variant(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = ""
)