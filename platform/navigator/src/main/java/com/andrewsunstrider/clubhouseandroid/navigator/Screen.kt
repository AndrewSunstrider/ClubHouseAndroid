package com.andrewsunstrider.clubhouseandroid.navigator

sealed class Screen {
    object Auth : Screen()

    override fun toString() = when (this) {
        Auth -> "Authorization Screen"
    }
}
