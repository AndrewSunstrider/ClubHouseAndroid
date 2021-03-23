package com.andrewsunstrider.clubhouseandroid.persistence

import android.content.SharedPreferences
import com.andrewsunstrider.clubhouseandroid.domain.AuthProvider

class AppPreferencesWrapper(private val prefs: SharedPreferences) : AuthProvider {

    override fun getUserID(): String {
        return prefs.getString(USER_ID, EMPTY_STRING)!!
    }

    override fun getDeviceID(): String {
        return prefs.getString(DEVICE_ID, EMPTY_STRING)!!
    }

    override fun getUserToken(): String {
        return  prefs.getString(USER_TOKEN, ANONYMOUS_TOKEN)!!
    }

    override fun getIsWaitlisted(): Boolean {
        return prefs.getBoolean(WAITLISTED, EMPTY_BOOLEAN)
    }

    override fun saveUserID() {
        prefs.edit().apply {
            putString(USER_ID, EMPTY_STRING)
            apply()
        }
    }

    override fun saveDeviceID() {
        prefs.edit().apply {
            putString(DEVICE_ID, EMPTY_STRING)
            apply()
        }
    }

    override fun saveUserToken() {
        prefs.edit().apply {
            putString(USER_TOKEN, EMPTY_STRING)
            apply()
        }
    }

    override fun saveIsWaitListed() {
        prefs.edit().apply {
            putBoolean(WAITLISTED, EMPTY_BOOLEAN)
            apply()
        }
    }

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
