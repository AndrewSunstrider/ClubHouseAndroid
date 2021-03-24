package com.andrewsunstrider.clubhouseandroid.rest

import com.andrewsunstrider.clubhouseandroid.domain.model.Authorisation
import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService

internal class AuthInfrastructure(private val clubHouseApi: ClubHouseAPI) : AuthService {

    override suspend fun sendNumber(phoneNumber: String) = managedExecution {
        clubHouseApi.sendNumber(phoneNumber.toRequest())
    }

    override suspend fun sendCode(
        phoneNumber: String,
        verificationCode: String
    ): Authorisation = managedExecution {
        clubHouseApi.sendCode(
            Pair(phoneNumber, verificationCode).toRequest()
        ).toDomain()
    }

    private fun String.toRequest() = HashMap<String, String>().apply {
        put(PHONE_NUMBER, this@toRequest)
    }

    private fun Pair<String, String>.toRequest() = HashMap<String, String>().apply {
        put(PHONE_NUMBER, this@toRequest.first)
        put(VERIFICATION_CODE, this@toRequest.second)
    }

    private companion object {
        const val PHONE_NUMBER = "phone_number"
        const val VERIFICATION_CODE = "verification_code"
    }
}