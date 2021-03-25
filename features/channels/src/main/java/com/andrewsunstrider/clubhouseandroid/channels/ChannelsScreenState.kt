package com.andrewsunstrider.clubhouseandroid.channels

sealed class ChannelsScreenState {
    object Idle : ChannelsScreenState()
    object Launching : ChannelsScreenState()
    object Success : ChannelsScreenState()
    data class Failed(val reason: Throwable) : ChannelsScreenState()
}