package com.mobsky.home.data.network.api.model.comics


import com.google.gson.annotations.SerializedName

data class DateResponse(
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("type")
    val type: String? = ""
)