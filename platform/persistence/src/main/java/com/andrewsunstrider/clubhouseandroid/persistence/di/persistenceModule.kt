package com.andrewsunstrider.clubhouseandroid.persistence.di

import com.andrewsunstrider.clubhouseandroid.persistence.AppPreferencesWrapper
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val persistenceModule = DI.Module("persistence") {

    bind<AppPreferencesWrapper>() with singleton {
        AppPreferencesWrapper(
            app = instance()
        )
    }
}