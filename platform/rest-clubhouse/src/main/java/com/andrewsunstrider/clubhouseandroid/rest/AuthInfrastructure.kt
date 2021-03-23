package com.andrewsunstrider.clubhouseandroid.rest

import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService

internal class AuthInfrastructure(private val clubHouseApi: ClubHouseAPI) : AuthService {

    override suspend fun sendNumber(phoneNumber: String) = managedExecution {
        clubHouseApi.sendNumber(phoneNumber.mapToSendNumberHashMap())
    }

    private fun String.mapToSendNumberHashMap() = HashMap<String, String>().apply {
        put("phone_number", this@mapToSendNumberHashMap)
    }
}