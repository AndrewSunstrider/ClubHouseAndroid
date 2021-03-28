package com.andrewsunstrider.clubhouseandroid.rest.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChannelsResponse(
    val channels: List<ChannelResponse>
)

@Serializable
data class ChannelResponse(
    @SerialName("creator_user_profile_id")
    val creatorUserProfileId: Int,
    @SerialName("channel_id")
    val channelId: Int,
    @SerialName("channel")
    val channel: String,
    @SerialName("topic")
    val topic: String?,
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
    var token: String? = null,
    @SerialName("is_handraise_enable")
    var isHandraiseEnabled: Boolean? = null,
    @SerialName("pubnub_token")
    var pubnubToken: Int? = null,
    @SerialName("pubnub_heartbeat_interval")
    var pubnubHeartbeatInterval: Int? = null
)

@Serializable
data class ChannelUserResponse(
    @SerialName("is_speaker")
    val isSpeaker: Boolean,
    @SerialName("is_moderator")
    val isModerator: Boolean,
    @SerialName("is_invited_as_speaker")
    var isInvitedAsSpeaker: Boolean? = null,
    @SerialName("is_new")
    var isNew: Boolean? = null,
    @SerialName("time_joined_as_speaker")
    val timeJoinedAsSpeaker: String?,
    @SerialName("first_name")
    var firstName: String? = null,
    @SerialName("is_muted")
    var isMuted: Boolean? = null,
    @SerialName("user_id")
    val userID: Int,
    @SerialName("name")
    val name: String,
    @SerialName("photo_url")
    val photoUrl: String?,
    @SerialName("username")
    var username: String? = null,
    @SerialName("is_follwed_by_speaker")
    var isFollwedBySpeaker: Boolean? = null
)