package com.andrewsunstrider.clubhouseandroid.persistence.di

import com.andrewsunstrider.clubhouseandroid.domain.AuthorisationProvider
import com.andrewsunstrider.clubhouseandroid.persistence.AppPreferencesWrapper
import com.andrewsunstrider.clubhouseandroid.persistence.AuthorisationInfrastructure
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val persistenceModule = DI.Module("persistence") {

    bind<AuthorisationProvider>() with provider {
        val wrapper = AppPreferencesWrapper(
            app = instance()
        )

        AuthorisationInfrastructure(wrapper.preferences, app = instance())
    }
}