package com.andrewsunstrider.clubhouseandroid.rest

import retrofit2.http.POST
import retrofit2.http.Query

interface ClubHouseDotIO {

    @POST("/start_phone_number_auth")
    suspend fun auth(
        @Query("phoneNumber") phoneNumber: String,
        @Query("verificationCode") verificationCode: String
    )

    companion object {
        const val API_URL = "https://www.clubhouseapi.com/api"
    }
}