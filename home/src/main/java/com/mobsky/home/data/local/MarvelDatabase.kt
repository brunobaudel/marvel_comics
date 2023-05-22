package com.mobsky.home.data.local

import com.mobsky.home.data.local.dao.model.CharactersEntity
import com.mobsky.home.data.local.dao.model.ComicsEntity
import com.mobsky.network.util.ResultWrapper

interface MarvelDatabase {

    suspend fun getComics(): ResultWrapper<ComicsEntity>

    suspend fun insertComics(comicsEntity: ComicsEntity): List<Long>

    suspend fun getCharacters(): ResultWrapper<CharactersEntity>

    suspend fun insertCharacters(comicsEntity: CharactersEntity): List<Long>

}