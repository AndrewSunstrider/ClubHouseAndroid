package com.andrewsunstrider.clubhouseandroid.rest

import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService

internal class AuthInfrastructure(private val rest: ClubHouseDotIO) : AuthService {

    override suspend fun callVerificationCode(phoneNumber: String) = managedExecution {
        rest.auth(phoneNumber)
    }
}