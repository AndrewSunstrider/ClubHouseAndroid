package com.andrewsunstrider.clubhouseandroid.domain.services

interface AuthService {
    suspend fun callVerificationCode(phoneNumber: String)
}
