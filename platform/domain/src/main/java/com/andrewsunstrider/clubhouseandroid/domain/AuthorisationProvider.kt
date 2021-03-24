package com.andrewsunstrider.clubhouseandroid.domain

interface AuthorisationProvider {

    fun getUserID(): String

    fun getDeviceID(): String

    fun getUserToken(): String

    fun isWaitlisted(): Boolean

    fun isLoggedIn(): Boolean

    fun saveUserID()

    fun saveUserToken()

    fun saveIsWaitListed()
}