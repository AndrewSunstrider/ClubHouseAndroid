package com.andrewsunstrider.clubhouseandroid.domain.services

interface AuthService {
    suspend fun getAuth(phoneNumber: String)
}
