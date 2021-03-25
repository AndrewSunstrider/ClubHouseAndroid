package com.andrewsunstrider.clubhouseandroid.domain.usecase

import com.andrewsunstrider.clubhouseandroid.domain.AuthorisationProvider
import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService

class LoginServiceInteractor(
    private val service: AuthService,
    private val authorisationProvider: AuthorisationProvider
) {

    suspend fun sendNumber(phoneNumber: String) {
        service.sendNumber(phoneNumber)
        authorisationProvider.setPhoneNumber(phoneNumber)
    }

    suspend fun sendCode(verificationCode: String) {
        val phoneNumber = authorisationProvider.getPhoneNumber()
        if (phoneNumber.isEmpty()) throw NullPointerException("Phone number is empty")

        val response = service.sendCode(phoneNumber, verificationCode)
        authorisationProvider.apply {
            saveUserID(response.userProfile.userId.toString())
            saveUserToken(response.authToken)
            saveIsWaitListed(response.isWaitlisted)
        }
    }
}