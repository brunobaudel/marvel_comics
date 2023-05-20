package com.mobsky.marvelcomics.di


import com.mobsky.marvelcomics.BuildConfig
import com.mobsky.network.StartNetworkParameters
import com.mobsky.network.startNetwork
import org.koin.core.module.Module
import org.koin.dsl.module

val startNetworkParameters = StartNetworkParameters(
    baseUrl = BuildConfig.BASE_URL,
    isDebug = BuildConfig.DEBUG
)

val appDiModule = module {

//    single {
//        get<Retrofit> {
//            parametersOf(startNetworkParameters)
//        }.create(::class.java)
//    }

//    single {
//        MarvelComicsDatabase.getDatabase(context = get()).aBibliaDigitalDAO()
//    }

}

fun getAppModules(): List<Module> =
    listOf(
        startNetwork,
        appDiModule
    )
//        .plus(homeModules)

