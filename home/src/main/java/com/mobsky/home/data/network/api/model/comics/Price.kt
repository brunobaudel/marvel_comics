package com.mobsky.home.data.network.api.model.comics


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("price")
    val price: Double? = 0.0,
    @SerializedName("type")
    val type: String? = ""
)