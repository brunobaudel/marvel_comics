package com.mobsky.home.data.network


import com.mobsky.home.data.network.api.model.comics.ComicsResponse
import com.mobsky.network.util.ResultWrapper

interface MarvelNetwork {

    suspend fun getComics(): ResultWrapper<ComicsResponse>


}