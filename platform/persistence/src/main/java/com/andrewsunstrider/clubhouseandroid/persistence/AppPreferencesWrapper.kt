package com.andrewsunstrider.clubhouseandroid.persistence

import android.content.SharedPreferences
import com.andrewsunstrider.clubhouseandroid.domain.AuthProvider

class AppPreferencesWrapper(private val prefs: SharedPreferences) : AuthProvider {

    override fun getUserID(): String = prefs.getString(USER_ID, EMPTY_STRING)!!

    override fun getDeviceID(): String = prefs.getString(DEVICE_ID, EMPTY_STRING)!!

    override fun getUserToken(): String = prefs.getString(USER_TOKEN, ANONYMOUS_TOKEN)!!

    override fun isWaitlisted(): Boolean = prefs.getBoolean(WAITLISTED, EMPTY_BOOLEAN)

    companion object {
        const val USER_ID = "user_id"
        const val DEVICE_ID = "device_id"
        const val USER_TOKEN = "user_token"
        const val WAITLISTED = "waitlisted"
        const val ANONYMOUS_TOKEN = "anonymous_token"
        const val EMPTY_BOOLEAN = false
        const val EMPTY_STRING = ""
    }
}
