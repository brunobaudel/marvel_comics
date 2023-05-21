package com.mobsky.home.data.network.api

import com.mobsky.home.data.network.api.model.comics.ComicsResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarvelApi {

    /**
     * Lista os quadrinhos
     */
    @GET("comics")
    suspend fun getComics(@QueryMap param: Map<String, String>): ComicsResponse

}