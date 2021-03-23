package com.andrewsunstrider.clubhouseandroid.di

import android.content.SharedPreferences
import com.andrewsunstrider.clubhouseandroid.BuildConfig
import com.andrewsunstrider.clubhouseandroid.logger.LogcatLogger
import com.andrewsunstrider.clubhouseandroid.logger.Logger
import com.andrewsunstrider.clubhouseandroid.navigation.ScreenLinks
import kotlinx.coroutines.Dispatchers
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val applicationModule = DI.Module("application") {

    bind<HttpUrl>() with singleton {
        requireNotNull(
            BuildConfig.CLUBHOUSE_API_URL.toHttpUrlOrNull()
        )
    }

    bind() from singleton {
        ScreenLinks.associations
    }

    bind() from singleton {
        Dispatchers.IO
    }

    bind<Logger>() with singleton {
        LogcatLogger
    }

    bind<SharedPreferences>() with singleton {
        instance()
    }
}
