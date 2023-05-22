package com.mobsky.home.data.network.api.model.comics


import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("characters")
    val characters: CharactersResponse? = CharactersResponse(),
    @SerializedName("collectedIssues")
    val collectedIssues: List<Any>? = listOf(),
    @SerializedName("collections")
    val collections: List<Any>? = listOf(),
    @SerializedName("creators")
    val creators: CreatorsResponse? = CreatorsResponse(),
    @SerializedName("dates")
    val dates: List<DateResponse>? = listOf(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("diamondCode")
    val diamondCode: String? = "",
    @SerializedName("digitalId")
    val digitalId: Int? = 0,
    @SerializedName("ean")
    val ean: String? = "",
    @SerializedName("events")
    val events: EventsResponse? = EventsResponse(),
    @SerializedName("format")
    val format: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("images")
    val images: List<Any>? = listOf(),
    @SerializedName("isbn")
    val isbn: String? = "",
    @SerializedName("issn")
    val issn: String? = "",
    @SerializedName("issueNumber")
    val issueNumber: Int? = 0,
    @SerializedName("modified")
    val modified: String? = "",
    @SerializedName("pageCount")
    val pageCount: Int? = 0,
    @SerializedName("prices")
    val prices: List<PriceResponse>? = listOf(),
    @SerializedName("resourceURI")
    val resourceURI: String? = "",
    @SerializedName("series")
    val series: SeriesResponse? = SeriesResponse(),
    @SerializedName("stories")
    val stories: StoriesResponse? = StoriesResponse(),
    @SerializedName("textObjects")
    val textObjects: List<Any>? = listOf(),
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse? = ThumbnailResponse(),
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("upc")
    val upc: String? = "",
    @SerializedName("urls")
    val urls: List<UrlResponse>? = listOf(),
    @SerializedName("variantDescription")
    val variantDescription: String? = "",
    @SerializedName("variants")
    val variants: List<VariantResponse>? = listOf()
)