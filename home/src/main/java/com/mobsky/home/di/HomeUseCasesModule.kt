package com.mobsky.home.di


import com.mobsky.home.domain.usecase.GetComicsUseCase
import com.mobsky.home.domain.usecase.GetHomeMenuUseCase
import org.koin.dsl.module

internal val homeUseCasesModules = module {

    single {
        GetComicsUseCase(marvelRepository = get())
    }

    single {
        GetHomeMenuUseCase()
    }

}
