package com.andrewsunstrider.clubhouseandroid.domain.factory

import com.andrewsunstrider.clubhouseandroid.domain.model.Channel
import com.andrewsunstrider.clubhouseandroid.domain.model.ChannelUser


object ChannelFactory {

    fun makeChannels(): List<Channel> {
        val channels = mutableListOf<Channel>()
        channels.apply {
            channels.add(
                Channel(
                    creatorUserProfileId = DomainDataFactory.randomInt(),
                    channelId = DomainDataFactory.randomInt(),
                    channel = DomainDataFactory.randomString(),
                    title = DomainDataFactory.randomString(),
                    isPrivate = DomainDataFactory.randomBoolean(),
                    isSocialMode = DomainDataFactory.randomBoolean(),
                    url = DomainDataFactory.randomString(),
                    numOther = DomainDataFactory.randomInt(),
                    hasBlockedSpeakers = DomainDataFactory.randomBoolean(),
                    isExploreChannel = DomainDataFactory.randomBoolean(),
                    numSpeakers = DomainDataFactory.randomInt(),
                    numAll = DomainDataFactory.randomInt(),
                    users = makeChannelUsers(),
                    token = DomainDataFactory.randomString(),
                    isHandraiseEnabled = DomainDataFactory.randomBoolean(),
                    pubnubToken = DomainDataFactory.randomInt(),
                    pubnubHeartbeatInterval = DomainDataFactory.randomInt()
                )
            )
        }
        return channels
    }

    private fun makeChannelUsers(): List<ChannelUser> {
        val users = mutableListOf<ChannelUser>()
        users.apply {
            users.add(
                ChannelUser(
                    isSpeaker = DomainDataFactory.randomBoolean(),
                    isModerator = DomainDataFactory.randomBoolean(),
                    isFollowedBySpeaker = DomainDataFactory.randomBoolean(),
                    isInvitedAsSpeaker = DomainDataFactory.randomBoolean(),
                    isNew = DomainDataFactory.randomBoolean(),
                    timeJoinedAsSpeaker = DomainDataFactory.randomString(),
                    firstName = DomainDataFactory.randomString(),
                    isMuted = DomainDataFactory.randomBoolean(),
                    userID = DomainDataFactory.randomInt(),
                    name = DomainDataFactory.randomString(),
                    photoUrl = DomainDataFactory.randomString(),
                    username = DomainDataFactory.randomString()
                )
            )
        }
        return users
    }
}