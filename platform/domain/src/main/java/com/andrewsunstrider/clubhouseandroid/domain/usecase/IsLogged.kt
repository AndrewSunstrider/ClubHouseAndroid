package com.andrewsunstrider.clubhouseandroid.domain.usecase

import com.andrewsunstrider.clubhouseandroid.domain.AuthorisationProvider

class IsLogged(
    private val authorisationProvider: AuthorisationProvider
) {

    fun execute() = authorisationProvider.isLoggedIn()
}