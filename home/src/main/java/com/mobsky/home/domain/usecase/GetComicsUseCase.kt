package com.mobsky.home.domain.usecase


import com.mobsky.home.data.repository.MarvelRepository
import com.mobsky.home.domain.model.Comics

class GetComicsUseCase(
    private val marvelRepository: MarvelRepository
) : UseCase<Comics, Unit>() {

    override suspend fun run(params: Unit): Comics = let {
        marvelRepository.getComics()
    }
}