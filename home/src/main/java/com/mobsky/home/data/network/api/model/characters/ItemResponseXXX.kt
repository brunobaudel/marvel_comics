package com.mobsky.home.data.network.api.model.characters


import com.google.gson.annotations.SerializedName

data class ItemResponseXXX(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = "",
    @SerializedName("type")
    val type: String? = ""
)