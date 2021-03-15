package com.andrewsunstrider.clubhouseandroid

import android.app.Application
import com.andrewsunstrider.clubhouseandroid.auth.di.authModule
import com.andrewsunstrider.clubhouseandroid.auth.di.verificationModule
import com.andrewsunstrider.clubhouseandroid.auth.di.welcomeModule
import com.andrewsunstrider.clubhouseandroid.di.applicationModule
import com.andrewsunstrider.clubhouseandroid.navigator.di.navigatorModule
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

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
        navigatorModule,
        verificationModule,
        welcomeModule
    )
}
