package com.andrewsunstrider.clubhouseandroid.domain

object SearchQueryValidation {

    fun validate(query: String) = REGEX.matches(query)

    private val REGEX by lazy {
        "^[a-zA-Z]{3,10}\$".toRegex()
    }
}
