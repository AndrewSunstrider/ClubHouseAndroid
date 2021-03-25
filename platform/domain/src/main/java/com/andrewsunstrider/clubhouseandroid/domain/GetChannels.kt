package com.andrewsunstrider.clubhouseandroid.domain

import com.andrewsunstrider.clubhouseandroid.domain.services.ChannelsService

class GetChannels(private val service: ChannelsService) {

    suspend fun getChannels() {
        service.availableChannels()
    }
}