package com.andrewsunstrider.clubhouseandroid.domain

import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService

class GetAuth(
    private val service: AuthService
) {
    suspend fun auth(phoneNumber: String) = service.getAuth(phoneNumber)
}