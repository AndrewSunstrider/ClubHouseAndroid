package com.andrewsunstrider.clubhouseandroid.navigator.di

import com.andrewsunstrider.clubhouseandroid.navigator.Navigator
import com.andrewsunstrider.clubhouseandroid.utilities.KodeinTags
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val navigatorModule = DI.Module("navigator") {
    bind() from provider {
        Navigator(
            host = instance(KodeinTags.hostActivity),
            links = instance()
        )
    }
}
