package com.andrewsunstrider.clubhouseandroid.auth.verification

sealed class VerificationScreenState {
    object Idle : VerificationScreenState()
    object Launching : VerificationScreenState()
    object Success : VerificationScreenState()
    object Failed : VerificationScreenState()
}