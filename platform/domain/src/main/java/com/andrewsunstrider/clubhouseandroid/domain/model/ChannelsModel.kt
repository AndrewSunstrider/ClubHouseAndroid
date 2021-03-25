package com.andrewsunstrider.clubhouseandroid.domain.model

data class Channel(
    val creatorUserProfileId: Int,
    val channelId: Int,
    val channel: String,
    val topic: String,
    val isPrivate: Boolean,
    val isSocialMode: Boolean,
    val url: String,
    val numOther: Int,
    val hasBlockedSpeakers: Boolean,
    val isExploreChannel: Boolean,
    val numSpeakers: Int,
    val numAll: Int,
    val users: List<ChannelUserResponse>,
    val token: String,
    val isHandraiseEnabled: Boolean,
    val pubnubToken: Int,
    val pubnubHeartbeatInterval: Int
)

data class ChannelUserResponse(
    val isSpeaker: Boolean,
    val isModerator: Boolean,
    val isFollowedBySpeaker: Boolean,
    val isInvitedAsSpeaker: Boolean,
    val isNew: Boolean,
    val timeJoinedAsSpeaker: String,
    val firstName: String,
    val isMuted: Boolean
)