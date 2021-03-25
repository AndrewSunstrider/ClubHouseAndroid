package com.andrewsunstrider.clubhouseandroid.rest.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChannelResponse(
    @SerialName("creator_user_profile_id")
    val creatorUserProfileId: Int,
    @SerialName("channel_id")
    val channelId: Int,
    @SerialName("channel")
    val channel: String,
    @SerialName("topic")
    val topic: String,
    @SerialName("is_private")
    val isPrivate: Boolean,
    @SerialName("is_social_mode")
    val isSocialMode: Boolean,
    @SerialName("url")
    val url: String,
    @SerialName("num_other")
    val numOther: Int,
    @SerialName("has_blocked_speakers")
    val hasBlockedSpeakers: Boolean,
    @SerialName("is_explore_channel")
    val isExploreChannel: Boolean,
    @SerialName("num_speakers")
    val numSpeakers: Int,
    @SerialName("num_all")
    val numAll: Int,
    @SerialName("users")
    val users: List<ChannelUserResponse>,
    @SerialName("token")
    val token: String,
    @SerialName("is_handraise_enable")
    val isHandraiseEnabled: Boolean,
    @SerialName("pubnub_token")
    val pubnubToken: Int,
    @SerialName("pubnub_heartbeat_interval")
    val pubnubHeartbeatInterval: Int
)

@Serializable
data class ChannelUserResponse(
    @SerialName("is_speaker")
    val isSpeaker: Boolean,
    @SerialName("is_moderator")
    val isModerator: Boolean,
    @SerialName("is_followed_by_speaker")
    val isFollowedBySpeaker: Boolean,
    @SerialName("is_invited_as_speaker")
    val isInvitedAsSpeaker: Boolean,
    @SerialName("is_new")
    val isNew: Boolean,
    @SerialName("time_joined_as_speaker")
    val timeJoinedAsSpeaker: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("is_muted")
    val isMuted: Boolean
)