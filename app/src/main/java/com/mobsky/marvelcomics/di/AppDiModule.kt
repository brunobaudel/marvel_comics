package com.mobsky.marvelcomics.di


import com.mobsky.home.data.network.api.MarvelApi
import com.mobsky.home.di.homeModules
import com.mobsky.marvelcomics.BuildConfig
import com.mobsky.marvelcomics.database.MarvelComicsDatabase
import com.mobsky.network.StartNetworkParameters
import com.mobsky.network.startNetwork
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit

val startNetworkParameters = StartNetworkParameters(
    baseUrl = BuildConfig.BASE_URL,
    isDebug = BuildConfig.DEBUG,
    queriesParameters = QueryStringCredentials().getQueryStringMap()
)

val appDiModule = module {

    single {
        get<Retrofit> {
            parametersOf(startNetworkParameters)
        }.create(MarvelApi::class.java)
    }

    single {
        MarvelComicsDatabase.getDatabase(context = get()).marvelDAO()
    }

}

fun getAppModules(): List<Module> =
    listOf(
        startNetwork,
        appDiModule
    ).plus(homeModules)

