package com.andrewsunstrider.clubhouseandroid.auth.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andrewsunstrider.clubhouseandroid.auth.welcome.WelcomeViewModel
import com.andrewsunstrider.clubhouseandroid.utilities.KodeinTags
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val welcomeModule = DI.Module("welcome") {

    bind() from provider {
        @Suppress("UNCHECKED_CAST") val factory = object : ViewModelProvider.Factory {
            override fun <VM : ViewModel> create(klass: Class<VM>) =
                WelcomeViewModel(isLogged = instance()) as VM
        }

        val host: FragmentActivity = instance(KodeinTags.hostActivity)
        ViewModelProvider(host, factory).get(WelcomeViewModel::class.java)
    }
}
