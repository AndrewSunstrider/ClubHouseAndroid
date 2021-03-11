package com.andrewsunstrider.clubhouseandroid.navigation

import android.app.Activity
import com.andrewsunstrider.clubhouseandroid.auth.AuthActivity
import com.andrewsunstrider.clubhouseandroid.auth.welcome.WelcomeActivity
import com.andrewsunstrider.clubhouseandroid.navigator.Screen

object ScreenLinks {

    val associations by lazy {
        mapOf<Screen, Class<out Activity>>(
            Screen.Welcome to WelcomeActivity::class.java,
            Screen.Auth to AuthActivity::class.java
        )
    }
}
