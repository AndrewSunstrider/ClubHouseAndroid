package com.andrewsunstrider.clubhouseandroid.domain

import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService

class GetVerificationCode(
    private val service: AuthService
) {
    suspend fun sendNumber(phoneNumber: String) = service.callVerificationCode(phoneNumber)
}