package com.andrewsunstrider.clubhouseandroid.auth.auth

sealed class AuthScreenState {
    object Idle : AuthScreenState()
    object Launching : AuthScreenState()
    object Success : AuthScreenState()
    object Failed : AuthScreenState()
}