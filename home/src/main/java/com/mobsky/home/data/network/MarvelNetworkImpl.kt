package com.mobsky.home.data.network

import com.mobsky.home.data.network.api.MarvelApi
import com.mobsky.home.data.network.api.model.characters.CharactersResponse
import com.mobsky.home.data.network.api.model.comics.ComicsResponse
import com.mobsky.network.util.ResultWrapper
import com.mobsky.network.util.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class MarvelNetworkImpl(
    private val gitHubApi: MarvelApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MarvelNetwork {

    override suspend fun getComics(param: Map<String, String>): ResultWrapper<ComicsResponse> =
        safeApiCall(
            dispatcher = dispatcher,
            apiCall = {
                gitHubApi.getComics(param)
            },
            transformError = {
//                Gson().fromJson(it, GitErrorModelResponse::class.java).message
                ""
            }
        )

    override suspend fun getCharacters(param: Map<String, String>): ResultWrapper<CharactersResponse> =
        safeApiCall(
            dispatcher = dispatcher,
            apiCall = {
                gitHubApi.getCharacters(param)
            },
            transformError = {
//                Gson().fromJson(it, GitErrorModelResponse::class.java).message
                ""
            }
        )

}
