package com.andrewsunstrider.clubhouseandroid.persistence

import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService

internal class AuthInfrastructure : AuthService {

    private var phone: String? = null

    override suspend fun getAuth(phoneNumber: String) {
        phone = phoneNumber
    }
}