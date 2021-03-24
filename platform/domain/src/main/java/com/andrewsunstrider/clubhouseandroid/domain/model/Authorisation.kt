package com.andrewsunstrider.clubhouseandroid.domain.model


data class Authorisation(
    val authToken: String,
    val isWaitlisted: Boolean,
    val userProfile: User
)

data class User(
    val userId: Int,
    val name: String,
    val photoUrl: String,
    val username: String
)