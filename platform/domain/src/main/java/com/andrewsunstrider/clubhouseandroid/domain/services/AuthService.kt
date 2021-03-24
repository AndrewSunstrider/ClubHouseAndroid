package com.andrewsunstrider.clubhouseandroid.domain.services

import com.andrewsunstrider.clubhouseandroid.domain.model.AuthorisationResponse

interface AuthService {

    suspend fun sendNumber(phoneNumber: String)

    suspend fun sendCode(phoneNumber: String, verificationCode: String): AuthorisationResponse
}
