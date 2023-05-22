package com.mobsky.home.data.network.api.model.comics


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    val extension: String? = null,
    @SerializedName("path")
    val path: String? = null
){
    fun getCompletePath() = "${path?.replace("http","https")}.${extension}"
}