package com.andrewsunstrider.clubhouseandroid.rest.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorisationResponse(
    @SerialName("auth_token")
    val authToken: String,
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("is_waitlisted")
    val isWaitlisted: Boolean,
    @SerialName("user_profile")
    val userProfile: UserResponse
)

@Serializable
data class UserResponse(
    @SerialName("user_id")
    val userId: Int,
    @SerialName("name")
    val name: String,
    @SerialName("photo_url")
    val photoUrl: String?,
    @SerialName("username")
    val username: String
)