package com.mobsky.home.data.network.api.model.comics


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("characters")
    val characters: Characters? = Characters(),
    @SerializedName("collectedIssues")
    val collectedIssues: List<Any>? = listOf(),
    @SerializedName("collections")
    val collections: List<Any>? = listOf(),
    @SerializedName("creators")
    val creators: Creators? = Creators(),
    @SerializedName("dates")
    val dates: List<Date>? = listOf(),
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("diamondCode")
    val diamondCode: String? = null,
    @SerializedName("digitalId")
    val digitalId: Int? = 0,
    @SerializedName("ean")
    val ean: String? = null,
    @SerializedName("events")
    val events: Events? = Events(),
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("images")
    val images: List<Any>? = listOf(),
    @SerializedName("isbn")
    val isbn: String? = null,
    @SerializedName("issn")
    val issn: String? = null,
    @SerializedName("issueNumber")
    val issueNumber: Int? = 0,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("pageCount")
    val pageCount: Int? = 0,
    @SerializedName("prices")
    val prices: List<Price>? = listOf(),
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: Series? = Series(),
    @SerializedName("stories")
    val stories: Stories? = Stories(),
    @SerializedName("textObjects")
    val textObjects: List<Any>? = listOf(),
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = Thumbnail(),
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("upc")
    val upc: String? = null,
    @SerializedName("urls")
    val urls: List<Url>? = listOf(),
    @SerializedName("variantDescription")
    val variantDescription: String? = null,
    @SerializedName("variants")
    val variants: List<Variant>? = listOf()
)