package com.mobsky.home.data.repository.mapper

import com.mobsky.home.data.local.dao.model.ComicEntity
import com.mobsky.home.data.local.dao.model.ComicsEntity
import com.mobsky.home.data.network.api.model.comics.ComicsResponse
import com.mobsky.home.domain.model.Comic
import com.mobsky.home.domain.model.Comics

fun ComicsResponse?.toComics(): Comics =
        this?.data?.results?.map{ result ->
            Comic(
                title = result.title.orEmpty(),
                description = result.description.orEmpty(),
                imageUrl = result.thumbnail?.getCompletePath().orEmpty()
            )
        }?: listOf()

fun ComicsEntity?.toComics(): Comics =
    this?.map{ result ->
        Comic(
            title = result.title,
            description = result.description,
            imageUrl = result.imageUrl
        )
    }?: listOf()

fun Comics?.toComicsEntity(): ComicsEntity =
   this?.map {  result->
       ComicEntity(
           title = result.title,
           description = result.description,
           imageUrl = result.imageUrl
       )
   }?: listOf()
