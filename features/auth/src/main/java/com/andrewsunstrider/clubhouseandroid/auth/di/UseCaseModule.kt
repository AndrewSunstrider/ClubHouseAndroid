package com.andrewsunstrider.clubhouseandroid.auth.di

import com.andrewsunstrider.clubhouseandroid.domain.LoginServiceInteractor
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
}
