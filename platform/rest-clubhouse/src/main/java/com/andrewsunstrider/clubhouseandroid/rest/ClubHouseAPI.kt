package com.andrewsunstrider.clubhouseandroid.rest

import com.andrewsunstrider.clubhouseandroid.rest.responses.AuthorisationResponse
import com.andrewsunstrider.clubhouseandroid.rest.responses.ChannelResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClubHouseAPI {

    @POST("start_phone_number_auth")
    suspend fun sendNumber(
        @Body phoneNumber: HashMap<String, String>
    )

    @POST("complete_phone_number_auth")
    suspend fun sendCode(
        @Body body: HashMap<String, String>
    ) : AuthorisationResponse

    @GET("get_channels")
    suspend fun getChannels(): List<ChannelResponse>
}