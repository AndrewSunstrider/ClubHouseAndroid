package com.andrewsunstrider.clubhouseandroid.rest

import retrofit2.http.Body
import retrofit2.http.POST

interface ClubHouseAPI {

    @POST("start_phone_number_auth")
    suspend fun sendNumber(@Body phoneNumber: HashMap<String, String>)
}