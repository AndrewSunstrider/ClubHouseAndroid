package com.andrewsunstrider.clubhouseandroid.rest

import com.andrewsunstrider.clubhouseandroid.domain.AuthorisationProvider
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class APIRequestInterceptor(
    private val preferences: AuthorisationProvider
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder().apply {
            // TODO: 20.03.2021 add locale in normal way
            addHeader("CH-Languages", "en-US")
            addHeader("CH-Locale", "[en_US]")
            addHeader("Accept", "application/json")
            addHeader("CH-AppBuild", API_BUILD_ID)
            addHeader("CH-AppVersion", API_BUILD_VERSION)
            addHeader("User-Agent", API_UA)
            addHeader("CH-DeviceId", preferences.getDeviceID())
        }

        return chain.proceed(builder.build())
    }


    companion object {
        private const val API_BUILD_ID = "304"
        private const val API_BUILD_VERSION = "0.1.28"
        private const val API_UA = "clubhouse/$API_BUILD_ID (iPhone; iOS 13.5.1; Scale/3.00)"

        const val PUBNUB_PUB_KEY = "pub-c-6878d382-5ae6-4494-9099-f930f938868b"
        const val PUBNUB_SUB_KEY = "sub-c-a4abea84-9ca3-11ea-8e71-f2b83ac9263d"

        const val TWITTER_ID = "NyJhARWVYU1X3qJZtC2154xSI"
        const val TWITTER_SECRET = "ylFImLBFaOE362uwr4jut8S8gXGWh93S1TUKbkfh7jDIPse02o"

        const val AGORA_KEY = "938de3e8055e42b281bb8c6f69c21f78"
        const val SENTRY_KEY = "5374a416cd2d4009a781b49d1bd9ef44@o325556.ingest.sentry.io/5245095"
        const val INSTABUG_KEY = "4e53155da9b00728caa5249f2e35d6b3"
        const val AMPLITUDE_KEY = "9098a21a950e7cb0933fb5b30affe5be"
    }
}