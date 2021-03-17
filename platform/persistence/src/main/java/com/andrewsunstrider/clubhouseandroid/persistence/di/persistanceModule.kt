package com.andrewsunstrider.clubhouseandroid.persistence.di

import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService
import com.andrewsunstrider.clubhouseandroid.persistence.AppPreferencesWrapper
import com.andrewsunstrider.clubhouseandroid.persistence.AuthInfrastructure
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val persistenceModule = DI.Module("persistence") {

    bind<AuthService>() with provider {

        AuthInfrastructure()
    }
}
