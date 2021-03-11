package com.andrewsunstrider.clubhouseandroid.di

import kotlinx.coroutines.Dispatchers
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val applicationModule = DI.Module("application") {

    bind() from singleton {
        Dispatchers.IO
    }
}
