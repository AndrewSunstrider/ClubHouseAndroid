package com.andrewsunstrider.clubhouseandroid.networking

import com.andrewsunstrider.clubhouseandroid.domain.errors.ErrorTransformer
import com.andrewsunstrider.clubhouseandroid.domain.errors.RemoteServiceIntegrationError
import kotlinx.serialization.SerializationException

object SerializationErrorTransformer : ErrorTransformer {

    override suspend fun transform(incoming: Throwable) =
        when (incoming) {
            is SerializationException -> RemoteServiceIntegrationError.UnexpectedResponse
            else -> incoming
        }
}
