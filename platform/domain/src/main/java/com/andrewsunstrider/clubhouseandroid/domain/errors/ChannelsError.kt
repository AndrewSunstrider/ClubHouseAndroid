package com.andrewsunstrider.clubhouseandroid.domain.errors

sealed class ChannelsError (message: String) : Throwable(message) {
    object EmptyList : ChannelsError("Channels list can not be empty")
}
