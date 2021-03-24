package com.andrewsunstrider.clubhouseandroid.navigation

import android.app.Activity
import com.andrewsunstrider.clubhouseandroid.auth.auth.AuthActivity
import com.andrewsunstrider.clubhouseandroid.auth.verification.VerificationActivity
import com.andrewsunstrider.clubhouseandroid.auth.welcome.WelcomeActivity
import com.andrewsunstrider.clubhouseandroid.channels.ChannelsActivity
import com.andrewsunstrider.clubhouseandroid.navigator.Screen

object ScreenLinks {

    val associations by lazy {
        mapOf<Screen, Class<out Activity>>(
            Screen.Welcome to WelcomeActivity::class.java,
            Screen.Auth to AuthActivity::class.java,
            Screen.Verification to VerificationActivity::class.java,
            Screen.Channels to ChannelsActivity::class.java
        )
    }
}
