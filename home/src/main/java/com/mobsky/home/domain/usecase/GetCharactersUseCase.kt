package com.mobsky.home.domain.usecase


import com.mobsky.home.data.repository.MarvelRepository
import com.mobsky.home.domain.model.Characters

class GetCharactersUseCase(
    private val marvelRepository: MarvelRepository
) : UseCase<Characters, Unit>() {

    override suspend fun run(params: Unit): Characters = let {
        marvelRepository.getCharacters()
    }
}