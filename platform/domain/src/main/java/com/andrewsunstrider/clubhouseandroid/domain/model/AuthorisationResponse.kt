package com.andrewsunstrider.clubhouseandroid.domain.model

data class AuthorisationResponse(
    val authToken: String,
    val isWaitlisted: String,
    val userProfile: User
)

data class User(
    val userId: Int,
    val name: String,
    val photoUrl: String,
    val username: String
)