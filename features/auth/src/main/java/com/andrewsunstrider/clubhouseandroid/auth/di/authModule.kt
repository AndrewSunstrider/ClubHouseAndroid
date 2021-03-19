package com.andrewsunstrider.clubhouseandroid.auth.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andrewsunstrider.clubhouseandroid.auth.auth.AuthViewModel
import com.andrewsunstrider.clubhouseandroid.domain.GetVerificationCode
import com.andrewsunstrider.clubhouseandroid.utilities.KodeinTags
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val authModule = DI.Module("auth") {

    bind() from provider {
        @Suppress("UNCHECKED_CAST") val factory = object : ViewModelProvider.Factory {
            val getCode = GetVerificationCode(
                service = instance()
            )

            override fun <VM : ViewModel> create(klass: Class<VM>) =
                AuthViewModel(getCode) as VM
        }

        val host: FragmentActivity = instance(KodeinTags.hostActivity)
        ViewModelProvider(host, factory).get(AuthViewModel::class.java)
    }
}
