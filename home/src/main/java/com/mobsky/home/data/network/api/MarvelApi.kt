package com.mobsky.home.data.network.api

import com.mobsky.home.data.network.api.model.comics.ComicsResponse
import retrofit2.http.GET

interface MarvelApi {

    /**
     * Lista os quadrinhos
     */
    @GET("")
    suspend fun getComics(): ComicsResponse


//            @GET("")
//            suspend fun getCharacters():
//
//            @GET("")
//            suspend fun getCreators():

//    /**
//     * Recupera um versiculo aleatorio do capitulo
//     */
//    @GET("verses/{version}/{abbrev}/random")
//    suspend fun getVerseToChapterRandom(
//        @Path("version") version: String = "nvi",
//        @Path("abbrev") abbrev: String
//    ): VerseBookResponse

}