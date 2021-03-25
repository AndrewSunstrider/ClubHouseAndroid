package com.andrewsunstrider.clubhouseandroid.domain.services

import com.andrewsunstrider.clubhouseandroid.domain.model.Channel

interface ChannelsService {

    suspend fun availableChannels(): Channel
}