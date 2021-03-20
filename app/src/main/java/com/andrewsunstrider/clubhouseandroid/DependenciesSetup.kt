package com.andrewsunstrider.clubhouseandroid

import android.app.Application
import com.andrewsunstrider.clubhouseandroid.auth.di.authModule
import com.andrewsunstrider.clubhouseandroid.auth.di.verificationModule
import com.andrewsunstrider.clubhouseandroid.auth.di.welcomeModule
import com.andrewsunstrider.clubhouseandroid.di.applicationModule
import com.andrewsunstrider.clubhouseandroid.navigator.di.navigatorModule
import com.andrewsunstrider.clubhouseandroid.persistence.di.persistenceModule
import com.andrewsunstrider.clubhouseandroid.rest.di.RestInfrastructureModule
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import java.util.*

class DependenciesSetup(private val app: Application) {

    val container by lazy {
        DI {
            modules.forEach { import(it) }
            bind() from singleton { app }
        }
    }

    // TODO: 20.03.2021 save in SharedPref for example
    private val deviceID by lazy {
        UUID.randomUUID().toString().toUpperCase(Locale.getDefault())
    }

    private val modules = listOf(
        applicationModule,
        authModule,
        navigatorModule,
        persistenceModule,
        RestInfrastructureModule(deviceID).diModule,
        verificationModule,
        welcomeModule
    )
}
