package com.andrewsunstrider.clubhouseandroid.auth.welcome

sealed class WelcomeScreenState {
    object Idle : WelcomeScreenState()
    object Launching : WelcomeScreenState()
    object Success : WelcomeScreenState()
    object Failed : WelcomeScreenState()
}