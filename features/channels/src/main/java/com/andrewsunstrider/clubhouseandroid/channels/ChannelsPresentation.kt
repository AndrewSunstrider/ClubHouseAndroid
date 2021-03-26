package com.andrewsunstrider.clubhouseandroid.channels

import com.andrewsunstrider.clubhouseandroid.domain.model.Channel
import com.andrewsunstrider.clubhouseandroid.domain.model.ChannelUser


// TODO: 25.03.2021 Add model with query
data class ChannelsPresentation(
    val relatedQuery: String,
    val channels: List<ChannelDisplayRow>
)

data class ChannelDisplayRow(
    val channelId: Int,
    val title: String?,
    val numSpeakers: Int,
    val numAll: Int,
    val users: List<ChannelUser>
) {


    companion object {

        operator fun invoke(channel: Channel) = with(channel) {
            ChannelDisplayRow(
                channelId = channelId,
                title = title,
                numSpeakers = numSpeakers,
                numAll = numAll,
                users = users
            )
        }
    }
}
