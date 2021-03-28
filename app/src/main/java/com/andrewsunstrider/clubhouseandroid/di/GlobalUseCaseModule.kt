package com.andrewsunstrider.clubhouseandroid.di

import com.andrewsunstrider.clubhouseandroid.domain.usecase.GetChannels
import com.andrewsunstrider.clubhouseandroid.domain.usecase.LoginServiceInteractor
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val useCaseModule = DI.Module("usecase") {

    bind() from provider {
        LoginServiceInteractor(
            service = instance(),
            authorisationProvider = instance()
        )
    }

    bind() from provider {
        GetChannels(
            service = instance()
        )
    }
}
