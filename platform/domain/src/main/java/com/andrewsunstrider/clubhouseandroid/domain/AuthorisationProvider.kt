package com.andrewsunstrider.clubhouseandroid.domain

interface AuthorisationProvider {

    fun getUserID(): String

    fun getDeviceID(): String

    fun getUserToken(): String

    fun getIsWaitlisted(): Boolean

    fun saveUserID()

    fun saveDeviceID()

    fun saveUserToken()

    fun saveIsWaitListed()
}