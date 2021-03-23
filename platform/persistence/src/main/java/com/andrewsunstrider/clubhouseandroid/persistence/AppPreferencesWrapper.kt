package com.andrewsunstrider.clubhouseandroid.persistence

import android.app.Application
import android.content.Context

internal class AppPreferencesWrapper(private val app: Application) {

    val preferences by lazy {
        app.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
    }

    private companion object {
        const val PREFS_FILE = "auth"
    }
}