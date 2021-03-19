package com.andrewsunstrider.clubhouseandroid.rest.di

import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService
import com.andrewsunstrider.clubhouseandroid.networking.RetrofitBuilder
import com.andrewsunstrider.clubhouseandroid.rest.APIRequestInterceptor
import com.andrewsunstrider.clubhouseandroid.rest.AuthInfrastructure
import com.andrewsunstrider.clubhouseandroid.rest.ClubHouseDotIO
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.*

val restInfrastructureModule = DI.Module("rest-infrastructure") {

    bind() from singleton {

        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val clubhouseInterceptor:Interceptor = APIRequestInterceptor()

        val okHttp = OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor(clubhouseInterceptor)
            .build()

        val retrofit = RetrofitBuilder(
            apiURL = instance(),
            httpClient = okHttp
        )

        retrofit.create(ClubHouseDotIO::class.java)
    }

    bind<AuthService>() with provider {
        AuthInfrastructure(
            rest = instance()
        )
    }
}
