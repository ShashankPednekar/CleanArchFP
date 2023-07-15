package com.ssp.network.provider

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal class NetworkProviderImpl : com.ssp.core.NetworkProvider {

    private companion object {
        const val CONNECT_TIMEOUT = 30L
        const val READ_TIMEOUT = 30L
    }

    private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

    private val okHttpClient: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()

    override fun <ApiClass : Any> getApi(
        apiClass: Class<ApiClass>,
        baseUrl: String
    ): ApiClass {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiClass) as ApiClass
    }
}