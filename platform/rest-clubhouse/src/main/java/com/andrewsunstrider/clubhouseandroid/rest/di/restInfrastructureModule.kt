package com.andrewsunstrider.clubhouseandroid.rest.di

import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService
import com.andrewsunstrider.clubhouseandroid.networking.RetrofitBuilder
import com.andrewsunstrider.clubhouseandroid.rest.APIRequestInterceptor
import com.andrewsunstrider.clubhouseandroid.rest.AuthInfrastructure
import com.andrewsunstrider.clubhouseandroid.rest.ClubHouseApi
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.*

class RestInfrastructureModule(
    deviceId: String
) {


    @ExperimentalSerializationApi
    val diModule = DI.Module("rest-infrastructure") {

        bind() from singleton {

            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val clubhouseInterceptor: Interceptor = APIRequestInterceptor(
                deviceId = deviceId
            )

            val okHttp = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(clubhouseInterceptor)
                .build()

            val retrofit = RetrofitBuilder(
                apiURL = instance(),
                httpClient = okHttp
            )

            retrofit.create(ClubHouseApi::class.java)
        }

        bind<AuthService>() with provider {
            AuthInfrastructure(
                clubHouseApi = instance()
            )
        }
    }
}