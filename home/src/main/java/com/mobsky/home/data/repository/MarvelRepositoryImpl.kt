package com.mobsky.home.data.repository

import com.mobsky.home.data.local.MarvelDatabase
import com.mobsky.home.data.network.MarvelNetwork
import com.mobsky.home.data.repository.mapper.toCharacterEntity
import com.mobsky.home.data.repository.mapper.toCharacters
import com.mobsky.home.data.repository.mapper.toComics
import com.mobsky.home.data.repository.mapper.toComicsEntity
import com.mobsky.home.domain.model.Characters
import com.mobsky.home.domain.model.Comics
import com.mobsky.home.domain.model.QueryStringFilters
import com.mobsky.network.util.getSuccessResultWrapper
import com.mobsky.network.util.result

class MarvelRepositoryImpl(
    private val marvelNetwork: MarvelNetwork,
    private val marvelLocal: MarvelDatabase,
) : MarvelRepository {

    //region Comics
    override suspend fun getComics(queryStringParameter: QueryStringFilters): Comics =
        result {

            var result = getComicsLocal()
            if (result.isEmpty()) {
                queryStringParameter.apply { limit = "30" }
                result = getComicsOnLine(queryStringParameter.getQueryStringMap())
                marvelLocal.insertComics(result.toComicsEntity())
            }
            result
        }

    private suspend fun getComicsOnLine(param: Map<String, String>): Comics =
        marvelNetwork.getComics(param).getSuccessResultWrapper().toComics()

    private suspend fun getComicsLocal(): Comics =
        marvelLocal.getComics().getSuccessResultWrapper().toComics()
    //endregion

    //region Characters
    override suspend fun getCharacters(queryStringParameter: QueryStringFilters): Characters =
        result {

            var result = getCharactersLocal()
            if (result.isEmpty()) {
                queryStringParameter.apply { limit = "30" }
                result = getCharactersOnLine(queryStringParameter.getQueryStringMap())
                marvelLocal.insertCharacters(result.toCharacterEntity())
            }
            result
        }

    private suspend fun getCharactersOnLine(param: Map<String, String>): Characters =
        marvelNetwork.getCharacters(param).getSuccessResultWrapper().toCharacters()

    private suspend fun getCharactersLocal(): Characters =
        marvelLocal.getCharacters().getSuccessResultWrapper().toCharacters()
    //endregion

}
