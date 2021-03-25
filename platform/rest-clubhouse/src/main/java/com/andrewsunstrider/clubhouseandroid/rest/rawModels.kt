package com.andrewsunstrider.clubhouseandroid.rest

import kotlinx.serialization.Serializable

@Serializable
data class RawAuth(
    val phoneNumber: String,
    val verificationCode: String
)