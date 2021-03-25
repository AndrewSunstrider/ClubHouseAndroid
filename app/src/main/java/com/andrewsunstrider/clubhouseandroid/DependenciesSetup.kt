package com.andrewsunstrider.clubhouseandroid

import android.app.Application
import com.andrewsunstrider.clubhouseandroid.auth.di.authModule
import com.andrewsunstrider.clubhouseandroid.auth.di.verificationModule
import com.andrewsunstrider.clubhouseandroid.auth.di.welcomeModule
import com.andrewsunstrider.clubhouseandroid.channels.di.channelsModule
import com.andrewsunstrider.clubhouseandroid.di.applicationModule
import com.andrewsunstrider.clubhouseandroid.di.useCaseModule
import com.andrewsunstrider.clubhouseandroid.navigator.di.navigatorModule
import com.andrewsunstrider.clubhouseandroid.persistence.di.persistenceModule
import com.andrewsunstrider.clubhouseandroid.rest.di.restInfrastructureModule
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

@Suppress("EXPERIMENTAL_API_USAGE")
class DependenciesSetup(private val app: Application) {

    val container by lazy {
        DI {
            modules.forEach { import(it) }
            bind() from singleton { app }
        }
    }

    private val modules = listOf(
        applicationModule,
        authModule,
        channelsModule,
        navigatorModule,
        persistenceModule,
        restInfrastructureModule,
        verificationModule,
        useCaseModule,
        welcomeModule
    )
}
