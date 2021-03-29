package com.andrewsunstrider.clubhouseandroid.persistence

import android.app.Application
import android.content.SharedPreferences
import com.andrewsunstrider.clubhouseandroid.domain.AuthorisationProvider
import java.util.*

class AuthorisationInfrastructure(
    private val prefs: SharedPreferences,
    private val app: Application
) : AuthorisationProvider {

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

    override fun isLoggedIn(): Boolean = getUserID().isNotEmpty()

    override fun saveUserID(value: String) {
        prefs.edit().apply {
            putString(USER_ID, value)
            apply()
        }
    }

    override fun saveUserToken(value: String) {
        prefs.edit().apply {
            putString(USER_TOKEN, value)
            apply()
        }
    }

    override fun saveIsWaitListed(value: Boolean) {
        prefs.edit().apply {
            putBoolean(WAITLISTED, value)
            apply()
        }
    }

    override fun getPhoneNumber() = prefs.getString(PHONE_NUMBER, EMPTY_STRING)!!

    override fun getLanguages(): String =
        app.applicationContext.resources.configuration.locales.toLanguageTags()

    override fun getLocale(): String =
        app.applicationContext.resources.configuration.locales.get(0).toLanguageTag()
            .replace('-', '_')

    override fun setPhoneNumber(phoneNumber: String) {
        prefs.edit().apply {
            putString(PHONE_NUMBER, phoneNumber)
            apply()
        }
    }

    private companion object {
        const val USER_ID = "user_id"
        const val DEVICE_ID = "device_id"
        const val USER_TOKEN = "user_token"
        const val WAITLISTED = "waitlisted"
        const val PHONE_NUMBER = "phone_number"
        const val ANONYMOUS_TOKEN = "anonymous_token"
        const val EMPTY_BOOLEAN = false
        const val EMPTY_STRING = ""
    }
}