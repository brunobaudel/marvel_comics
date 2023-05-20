package com.mobsky.home.data.local

import com.mobsky.home.data.local.dao.MarvelDAO
import com.mobsky.home.data.local.dao.model.ComicsEntity
import com.mobsky.network.util.ResultWrapper

class MarvelDatabaseImpl(private val marvelDAO: MarvelDAO) :
    MarvelDatabase {

    override suspend fun getComics(): ResultWrapper<ComicsEntity> = try {
        val result = marvelDAO.getComics()
        ResultWrapper.Success(result)
    } catch (exception: Exception) {
        ResultWrapper.GenericError(0, exception.message.orEmpty())
    }

    override suspend fun insertComics(comics: ComicsEntity) : List<Long> =
        marvelDAO.insertComics(comics)


}