package com.mobsky.home.di


import com.mobsky.home.data.local.MarvelDatabase
import com.mobsky.home.data.local.MarvelDatabaseImpl
import com.mobsky.home.data.network.MarvelNetwork
import com.mobsky.home.data.network.MarvelNetworkImpl
import com.mobsky.home.data.repository.MarvelRepository
import com.mobsky.home.data.repository.MarvelRepositoryImpl
import org.koin.dsl.module

private val homeNetworkModules = module {
    single<MarvelNetwork> { MarvelNetworkImpl(get()) }
}

private val homeDataBaseModules = module {
    single<MarvelDatabase> { MarvelDatabaseImpl(get()) }
}

private val homeRepositoryModule = module {
    single<MarvelRepository> {
        MarvelRepositoryImpl(
            marvelNetwork = get(), marvelLocal = get()
        )
    }
}

val homeModules = listOf(
    homeNetworkModules,
    homeDataBaseModules,
    homeRepositoryModule,
    homeUseCasesModules,
    homeViewModelModules
)