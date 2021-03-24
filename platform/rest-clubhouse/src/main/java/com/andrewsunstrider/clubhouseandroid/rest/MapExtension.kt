package com.andrewsunstrider.clubhouseandroid.rest

import com.andrewsunstrider.clubhouseandroid.domain.model.Authorisation
import com.andrewsunstrider.clubhouseandroid.domain.model.User


fun AuthorisationResponse.toDomain() = Authorisation(
    authToken = authToken,
    isWaitlisted = isWaitlisted,
    userProfile = User(
        userId = userProfile.userId,
        name = userProfile.name,
        photoUrl = userProfile.photoUrl,
        username = userProfile.username
    )
)
