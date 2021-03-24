package com.andrewsunstrider.clubhouseandroid.persistence

import android.content.SharedPreferences
import com.andrewsunstrider.clubhouseandroid.domain.AuthorisationProvider
import java.util.*

class AuthorisationInfrastructure(private val prefs: SharedPreferences) : AuthorisationProvider {

    override fun getUserID(): String {
        return prefs.getString(USER_ID, EMPTY_STRING)!!
    }

    override fun getDeviceID(): String {
        val deviceId = prefs.getString(DEVICE_ID, EMPTY_STRING)!!
        return when {
            deviceId.isNotEmpty() -> deviceId
            else -> {
                val newDeviceID = UUID.randomUUID().toString().toUpperCase(Locale.ROOT)

                prefs.edit().apply {
                    putString(DEVICE_ID, newDeviceID)
                    apply()
                }
                newDeviceID
            }
        }
    }

    override fun getUserToken(): String {
        return prefs.getString(USER_TOKEN, ANONYMOUS_TOKEN)!!
    }

    override fun isWaitlisted(): Boolean {
        return prefs.getBoolean(WAITLISTED, EMPTY_BOOLEAN)
    }

    override fun isLoggedIn(): Boolean {
        return USER_ID != EMPTY_STRING
    }

    override fun saveUserID() {
        prefs.edit().apply {
            putString(USER_ID, EMPTY_STRING)
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

    private companion object {
        const val USER_ID = "user_id"
        const val DEVICE_ID = "device_id"
        const val USER_TOKEN = "user_token"
        const val WAITLISTED = "waitlisted"
        const val ANONYMOUS_TOKEN = "anonymous_token"
        const val EMPTY_BOOLEAN = false
        const val EMPTY_STRING = ""
    }
}