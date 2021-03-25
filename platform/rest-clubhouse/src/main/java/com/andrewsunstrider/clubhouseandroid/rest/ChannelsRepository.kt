package com.andrewsunstrider.clubhouseandroid.rest

import com.andrewsunstrider.clubhouseandroid.domain.model.Channel
import com.andrewsunstrider.clubhouseandroid.domain.services.ChannelsService

class ChannelsRepository(private val clubHouseApi: ClubHouseAPI) : ChannelsService {
    override suspend fun availableChannels(): List<Channel> = managedExecution {
        clubHouseApi.getChannels().toDomain()
    }
}