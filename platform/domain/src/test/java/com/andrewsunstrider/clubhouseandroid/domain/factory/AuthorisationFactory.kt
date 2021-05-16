package com.andrewsunstrider.clubhouseandroid.domain.factory

import com.andrewsunstrider.clubhouseandroid.domain.model.Authorisation
import com.andrewsunstrider.clubhouseandroid.domain.model.User

object AuthorisationFactory {

    fun makeAuthorisation() = Authorisation(
        authToken = DomainDataFactory.randomString(),
        isWaitlisted = DomainDataFactory.randomBoolean(),
        userProfile = makeUser()
    )

    private fun makeUser() = User(
        userId = DomainDataFactory.randomInt(),
        name = DomainDataFactory.randomString(),
        photoUrl = DomainDataFactory.randomString(),
        username = DomainDataFactory.randomString()
    )
}