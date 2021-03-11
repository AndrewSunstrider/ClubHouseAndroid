package com.andrewsunstrider.clubhouseandroid.di

import com.andrewsunstrider.clubhouseandroid.logger.LogcatLogger
import com.andrewsunstrider.clubhouseandroid.logger.Logger
import com.andrewsunstrider.clubhouseandroid.navigation.ScreenLinks
import kotlinx.coroutines.Dispatchers
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val applicationModule = DI.Module("application") {

    bind() from singleton {
        ScreenLinks.associations
    }

    bind() from singleton {
        Dispatchers.IO
    }

    bind<Logger>() with singleton {
        LogcatLogger
    }
}
