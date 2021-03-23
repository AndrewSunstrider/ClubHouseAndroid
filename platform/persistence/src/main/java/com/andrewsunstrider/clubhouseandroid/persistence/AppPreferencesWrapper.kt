package com.andrewsunstrider.clubhouseandroid.persistence

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import java.util.*

class AppPreferencesWrapper(private val app: Application) {

    var deviceID: String? = null
    var userID: String? = null
    var userToken: String? = null
    var isWaitlisted = false

    init {
        load()
    }

    fun load() {
        val prefs: SharedPreferences = preferences
        deviceID = prefs.getString("device_id", null)
        userID = prefs.getString("user_id", null)
        userToken = prefs.getString("user_token", null)
        isWaitlisted = prefs.getBoolean("waitlisted", false)
        if (deviceID == null) {
            deviceID = UUID.randomUUID().toString().toUpperCase(Locale.getDefault())
            write()
        }
    }

    fun write() {
        preferences.edit()
            .putString("device_id", deviceID)
            .putString("user_id", userID)
            .putString("user_token", userToken)
            .putBoolean("waitlisted", isWaitlisted)
            .apply()
    }

    fun isLoggedIn(): Boolean {
        return userID != null
    }


    val preferences: SharedPreferences by lazy {
        app.getSharedPreferences(PREFS_FILE, MODE_PRIVATE)
    }

    private companion object {
        const val PREFS_FILE = "last-searches"
    }
}
