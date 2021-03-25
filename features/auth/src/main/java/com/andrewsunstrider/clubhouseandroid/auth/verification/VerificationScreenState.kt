package com.andrewsunstrider.clubhouseandroid.auth.verification

sealed class VerificationScreenState {
    object Idle : VerificationScreenState()
    object Launching : VerificationScreenState()
    object Success : VerificationScreenState()
    data class Failed(val error: Throwable) : VerificationScreenState()
    object ShowChannelsScreen : VerificationScreenState()
}