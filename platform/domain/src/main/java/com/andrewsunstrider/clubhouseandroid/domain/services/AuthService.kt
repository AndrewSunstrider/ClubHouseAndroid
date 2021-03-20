package com.andrewsunstrider.clubhouseandroid.domain.services

interface AuthService {
    suspend fun sendNumber(phoneNumber: String)
}
