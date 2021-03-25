package com.andrewsunstrider.clubhouseandroid.navigator

sealed class Screen {

    object Welcome : Screen()
    object Auth : Screen()
    object Verification : Screen()
    object Channels : Screen()

    override fun toString() = when (this) {
        Welcome -> "Welcome Screen"
        Auth -> "Authorization Screen"
        Verification -> "Verification Screen"
        Channels -> "Channels"
        else -> throw IllegalArgumentException("Unknown screen!")
    }
}
