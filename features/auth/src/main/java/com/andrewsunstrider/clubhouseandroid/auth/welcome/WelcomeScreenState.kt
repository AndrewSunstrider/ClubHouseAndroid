package com.andrewsunstrider.clubhouseandroid.auth.welcome

sealed class WelcomeScreenState {
    object Idle : WelcomeScreenState()
    object Launching : WelcomeScreenState()
    object Success : WelcomeScreenState()
    data class Failed(val error: Throwable) : WelcomeScreenState()
    object ShowRegistrationScreen : WelcomeScreenState()
    object ShowChannelsScreen : WelcomeScreenState()
}