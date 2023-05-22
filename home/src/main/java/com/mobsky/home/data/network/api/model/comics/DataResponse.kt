package com.mobsky.home.data.network.api.model.comics


import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("limit")
    val limit: Int? = 0,
    @SerializedName("offset")
    val offset: Int? = 0,
    @SerializedName("results")
    val results: List<ResultResponse>? = listOf(),
    @SerializedName("total")
    val total: Int? = 0
)