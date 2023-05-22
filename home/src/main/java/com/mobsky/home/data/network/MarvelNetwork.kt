package com.mobsky.home.data.network


import com.mobsky.home.data.network.api.model.characters.CharactersResponse
import com.mobsky.home.data.network.api.model.comics.ComicsResponse
import com.mobsky.network.util.ResultWrapper

interface MarvelNetwork {
    suspend fun getComics(param: Map<String, String>): ResultWrapper<ComicsResponse>
    suspend fun getCharacters(param: Map<String, String>): ResultWrapper<CharactersResponse>
}