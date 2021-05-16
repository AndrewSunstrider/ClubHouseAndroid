package com.andrewsunstrider.clubhouseandroid.rest

import com.andrewsunstrider.clubhouseandroid.networking.HttpIntegrationErrorTransformer
import com.andrewsunstrider.clubhouseandroid.networking.NetworkingErrorTransformer
import com.andrewsunstrider.clubhouseandroid.networking.SerializationErrorTransformer

private val transformers = listOf(
    HttpIntegrationErrorTransformer,
    NetworkingErrorTransformer,
    SerializationErrorTransformer
)

suspend fun <T> managedExecution(target: suspend () -> T): T =
    try {
        target.invoke()
    } catch (incoming: Throwable) {
        throw transformers
            .map { it.transform(incoming) }
            .reduce { transformed, another ->
                when {
                    transformed == another -> transformed
                    another == incoming -> transformed
                    else -> another
                }
            }
    }
