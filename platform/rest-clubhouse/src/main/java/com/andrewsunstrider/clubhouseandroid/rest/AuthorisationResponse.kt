package com.andrewsunstrider.clubhouseandroid.rest

import kotlinx.serialization.Serializable

@Serializable
data class AuthorisationResponse(
    val authToken: String,
    val isWaitlisted: Boolean,
    val userProfile: UserResponse
)

@Serializable
data class UserResponse(
    val userId: Int,
    val name: String,
    val photoUrl: String,
    val username: String
)