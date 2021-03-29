package com.andrewsunstrider.clubhouseandroid.domain.usecase

import com.andrewsunstrider.clubhouseandroid.domain.model.Channel
import com.andrewsunstrider.clubhouseandroid.domain.services.ChannelsService

class GetChannels(private val service: ChannelsService) {

    suspend fun getChannels(): List<Channel> = service.availableChannels()
}