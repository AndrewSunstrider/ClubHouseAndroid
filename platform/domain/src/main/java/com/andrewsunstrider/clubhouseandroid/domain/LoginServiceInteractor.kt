package com.andrewsunstrider.clubhouseandroid.domain

import com.andrewsunstrider.clubhouseandroid.domain.model.AuthorisationResponse
import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService

class LoginServiceInteractor(
    private val service: AuthService
) {

    suspend fun sendNumber(phoneNumber: String) = service.sendNumber(phoneNumber)

    suspend fun sendCode(phoneNumber: String, verificationCode: String): AuthorisationResponse =
        service.sendCode(phoneNumber, verificationCode)
}