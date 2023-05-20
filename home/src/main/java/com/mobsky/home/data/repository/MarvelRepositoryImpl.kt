package com.mobsky.home.data.repository


import com.mobsky.home.data.local.MarvelDatabase
import com.mobsky.home.data.network.MarvelNetwork
import com.mobsky.home.data.repository.mapper.toComics
import com.mobsky.home.data.repository.mapper.toComicsEntity
import com.mobsky.home.domain.model.Comics
import com.mobsky.network.util.getSuccessResultWrapper
import com.mobsky.network.util.result

class MarvelRepositoryImpl(
    private val marvelNetwork: MarvelNetwork,
    private val marvelLocal: MarvelDatabase,
) : MarvelRepository {


    override suspend fun getComics(): Comics =
        result {

            var result = getComicsLocal()

            if (result.isEmpty()) {
                result = getComicsOnLine()
                marvelLocal.insertComics(result.toComicsEntity())
            }

            result
        }

    private suspend fun getComicsOnLine(): Comics =
        marvelNetwork.getComics().getSuccessResultWrapper().toComics()

    private suspend fun getComicsLocal(): Comics =
        marvelLocal.getComics().getSuccessResultWrapper().toComics()

}
