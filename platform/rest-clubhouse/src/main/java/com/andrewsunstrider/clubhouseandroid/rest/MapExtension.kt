package com.andrewsunstrider.clubhouseandroid.rest

import com.andrewsunstrider.clubhouseandroid.domain.model.Authorisation
import com.andrewsunstrider.clubhouseandroid.domain.model.Channel
import com.andrewsunstrider.clubhouseandroid.domain.model.ChannelUser
import com.andrewsunstrider.clubhouseandroid.domain.model.User
import com.andrewsunstrider.clubhouseandroid.rest.responses.AuthorisationResponse
import com.andrewsunstrider.clubhouseandroid.rest.responses.ChannelResponse
import com.andrewsunstrider.clubhouseandroid.rest.responses.ChannelUserResponse


fun AuthorisationResponse.toDomain() = Authorisation(
    authToken = authToken,
    isWaitlisted = isWaitlisted,
    userProfile = User(
        userId = userProfile.userId,
        name = userProfile.name ?: "",
        photoUrl = userProfile.photoUrl ?: "",
        username = userProfile.username ?: ""
    )
)

fun List<ChannelResponse>.toDomain(): List<Channel> {
    val channels = mutableListOf<Channel>()
    this.forEach { response ->
        channels.add(
            Channel(
                channel = response.channel,
                channelId = response.channelId,
                creatorUserProfileId = response.creatorUserProfileId,
                hasBlockedSpeakers = response.hasBlockedSpeakers,
                isExploreChannel = response.isExploreChannel,
                isHandraiseEnabled = response.isHandraiseEnabled ?: false,
                isPrivate = response.isPrivate,
                isSocialMode = response.isSocialMode,
                numAll = response.numAll,
                numOther = response.numOther,
                numSpeakers = response.numSpeakers,
                pubnubHeartbeatInterval = response.pubnubHeartbeatInterval ?: -1,
                pubnubToken = response.pubnubToken ?: -1,
                token = response.token ?: "",
                title = response.topic ?: "",
                url = response.url,
                users = response.users.toUsers()
            )
        )
    }
    return channels
}

fun List<ChannelUserResponse>.toUsers(): List<ChannelUser> {
    val users = mutableListOf<ChannelUser>()
    this.forEach { response ->
        users.add(
            ChannelUser(
                firstName = response.firstName ?: "",
                isSpeaker = response.isSpeaker,
                isInvitedAsSpeaker = response.isInvitedAsSpeaker ?: false,
                isModerator = response.isModerator,
                isMuted = response.isMuted ?: false,
                isNew = response.isNew ?: false,
                timeJoinedAsSpeaker = response.timeJoinedAsSpeaker ?: "",
                name = response.name,
                photoUrl = response.photoUrl ?: "",
                userID = response.userID,
                username = response.username ?: "",
                isFollowedBySpeaker = response.isFollwedBySpeaker ?: false
            )
        )
    }
    return users
}