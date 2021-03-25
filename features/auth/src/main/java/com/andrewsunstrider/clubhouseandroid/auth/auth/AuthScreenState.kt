package com.andrewsunstrider.clubhouseandroid.auth.auth

sealed class AuthScreenState {
    object Idle : AuthScreenState()
    object Launching : AuthScreenState()
    object Success : AuthScreenState()
    data class Failed(val reason: Throwable) : AuthScreenState()
    object ShowVerification : AuthScreenState()
}