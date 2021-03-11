package com.andrewsunstrider.clubhouseandroid.domain.errors

interface ErrorTransformer {

    suspend fun transform(incoming: Throwable): Throwable
}
