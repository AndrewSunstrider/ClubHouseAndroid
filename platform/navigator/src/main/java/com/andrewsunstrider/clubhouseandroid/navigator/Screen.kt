package com.andrewsunstrider.clubhouseandroid.navigator

sealed class Screen {

    object Welcome : Screen()
    object Auth : Screen()
    object Verification : Screen()

    override fun toString() = when (this) {
        Welcome -> "Welcome Screen"
        Auth -> "Authorization Screen"
        Verification -> "VerificationScreen"
        else -> throw IllegalArgumentException("Unknown screen!")
    }
}
