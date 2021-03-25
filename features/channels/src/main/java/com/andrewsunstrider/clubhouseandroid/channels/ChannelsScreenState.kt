package com.andrewsunstrider.clubhouseandroid.channels

sealed class ChannelsScreenState {
    object Idle : ChannelsScreenState()
    object Launching : ChannelsScreenState()
    data class Success(val value: List<ChannelDisplayRow>) : ChannelsScreenState()
    data class Failed(val reason: Throwable) : ChannelsScreenState()
}