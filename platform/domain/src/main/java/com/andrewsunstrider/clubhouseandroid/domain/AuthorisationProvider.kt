package com.andrewsunstrider.clubhouseandroid.domain

interface AuthorisationProvider {

    fun getUserID(): String

    fun getDeviceID(): String

    fun getUserToken(): String

    fun isWaitlisted(): Boolean

    fun isLoggedIn(): Boolean

    fun saveUserID(value: String)

    fun saveUserToken(value: String)

    fun saveIsWaitListed(value: Boolean)

    fun setPhoneNumber(phoneNumber: String)

    fun getPhoneNumber(): String
}