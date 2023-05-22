package com.mobsky.home.data.network.api.model.characters


import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("comics")
    val comics: ComicsResponse? = ComicsResponse(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("events")
    val events: EventsResponse? = EventsResponse(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("modified")
    val modified: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = "",
    @SerializedName("series")
    val series: SeriesResponse? = SeriesResponse(),
    @SerializedName("stories")
    val stories: StoriesResponse? = StoriesResponse(),
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse? = ThumbnailResponse(),
    @SerializedName("urls")
    val urls: List<UrlResponse>? = listOf()
)