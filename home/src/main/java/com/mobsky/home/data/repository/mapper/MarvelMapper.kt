package com.mobsky.home.data.repository.mapper

import com.mobsky.home.data.local.dao.model.CharacterEntity
import com.mobsky.home.data.local.dao.model.CharactersEntity
import com.mobsky.home.data.local.dao.model.ComicEntity
import com.mobsky.home.data.local.dao.model.ComicsEntity
import com.mobsky.home.data.network.api.model.characters.CharactersResponse
import com.mobsky.home.data.network.api.model.comics.ComicsResponse
import com.mobsky.home.domain.model.Characters
import com.mobsky.home.domain.model.Character
import com.mobsky.home.domain.model.Comic
import com.mobsky.home.domain.model.Comics

//region Comics
fun ComicsResponse?.toComics(): Comics =
    this?.data?.results?.map { result ->
        Comic(
            title = result.title.orEmpty(),
            description = result.description.orEmpty(),
            imageUrl = result.thumbnail?.getCompletePath().orEmpty(),
            pageCount = result.pageCount ?: 0
        )
    } ?: listOf()

fun ComicsEntity?.toComics(): Comics =
    this?.map { result ->
        Comic(
            title = result.title,
            description = result.description,
            imageUrl = result.imageUrl
        )
    } ?: listOf()

fun Comics?.toComicsEntity(): ComicsEntity =
    this?.map { result ->
        ComicEntity(
            title = result.title,
            description = result.description,
            imageUrl = result.imageUrl
        )
    } ?: listOf()
//endregion

//region Characters
fun CharactersResponse?.toCharacters(): Characters =
    this?.data?.results?.map { result ->
        Character(
            title = result.name.orEmpty(),
            description = result.description.orEmpty(),
            imageUrl = result.thumbnail?.getCompletePath().orEmpty()
        )
    } ?: listOf()

fun CharactersEntity?.toCharacters(): Characters =
    this?.map { result ->
        Character(
            title = result.title,
            description = result.description,
            imageUrl = result.imageUrl
        )
    } ?: listOf()

fun Characters?.toCharacterEntity(): CharactersEntity =
    this?.map { result ->
        CharacterEntity(
            title = result.title,
            description = result.description,
            imageUrl = result.imageUrl
        )
    } ?: listOf()
//endregion