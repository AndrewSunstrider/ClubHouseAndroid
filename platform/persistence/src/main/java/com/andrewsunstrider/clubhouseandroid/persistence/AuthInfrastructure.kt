package com.andrewsunstrider.clubhouseandroid.persistence

import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService

internal class AuthInfrastructure : AuthService {
    override suspend fun getAuth(phoneNumber: String) {}
}