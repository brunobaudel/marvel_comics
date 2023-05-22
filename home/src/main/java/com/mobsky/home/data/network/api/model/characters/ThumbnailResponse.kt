package com.mobsky.home.data.network.api.model.characters


import com.google.gson.annotations.SerializedName

data class ThumbnailResponse(
    @SerializedName("extension")
    val extension: String? = "",
    @SerializedName("path")
    val path: String? = ""
){
    fun getCompletePath(): String = "${path?.replace("http", "https")}.$extension"
}