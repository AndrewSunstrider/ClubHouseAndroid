package com.andrewsunstrider.clubhouseandroid.rest.di

import com.andrewsunstrider.clubhouseandroid.networking.RetrofitBuilder
import com.andrewsunstrider.clubhouseandroid.rest.ClubHouseDotIO
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val restInfrastructureModule = DI.Module("rest-infrastructure") {

    bind() from singleton {

        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttp = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val retrofit = RetrofitBuilder(
            apiURL = instance(),
            httpClient = okHttp
        )

        retrofit.create(ClubHouseDotIO::class.java)
    }
}
