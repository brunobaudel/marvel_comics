package com.mobsky.network

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


typealias TimeInMileSeconds = Long

data class StartNetworkParameters(
    val baseUrl: String,
    val isDebug: Boolean = false,
    val okHttpClient: OkHttpClient? = null,
    val readTimeOut: TimeInMileSeconds = 3000,
    val writeTimeOut: TimeInMileSeconds = 3000,
    val headers: Map<String, String> = mapOf(),
    val queriesParameters: Map<String, String>? = mapOf()
) {

    fun getHttpClientDefault(): OkHttpClient = let {

        val logging = HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }


        val okHttpClientDefault = OkHttpClient
            .Builder().apply {

                if (isDebug)
                    addInterceptor(logging)

                readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
                writeTimeout(writeTimeOut, TimeUnit.MILLISECONDS)
                addInterceptor { chain ->

                    val request: Request =
                        chain.request()
                            .newBuilder()
                            .headers(headers)
                            .url(chain.request().url.queriesParameters(queriesParameters))
                            .build()

                    chain.proceed(request)
                }
            }.build()

        okHttpClient ?: okHttpClientDefault

    }

    private fun Request.Builder.headers(headers: Map<String, String>): Request.Builder {
        headers.forEach { (name, value) ->
            this.addHeader(name, value)
        }
        return this
    }

    private fun HttpUrl.queriesParameters(queries: Map<String, String>?): HttpUrl {
        val url = this.newBuilder()
        queries?.forEach { (name, value) ->
            url.addQueryParameter(name, value)
        }
        return url.build()
    }

}