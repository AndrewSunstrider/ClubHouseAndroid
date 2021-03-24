package com.andrewsunstrider.clubhouseandroid.networking

import com.andrewsunstrider.clubhouseandroid.domain.errors.ErrorTransformer
import com.andrewsunstrider.clubhouseandroid.domain.errors.RemoteServiceIntegrationError
import retrofit2.HttpException

object HttpIntegrationErrorTransformer : ErrorTransformer {

    override suspend fun transform(incoming: Throwable) = when (incoming) {
        is HttpException -> translateUsingStatusCode(incoming.code())
        else -> incoming
    }

    private fun translateUsingStatusCode(code: Int) = when (code) {
        in 400..499 -> RemoteServiceIntegrationError.ClientOrigin
        else -> RemoteServiceIntegrationError.RemoteSystem
    }
}
