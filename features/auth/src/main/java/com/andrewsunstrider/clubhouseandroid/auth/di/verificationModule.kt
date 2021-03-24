package com.andrewsunstrider.clubhouseandroid.auth.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andrewsunstrider.clubhouseandroid.auth.verification.VerificationViewModel
import com.andrewsunstrider.clubhouseandroid.domain.LoginServiceInteractor
import com.andrewsunstrider.clubhouseandroid.utilities.KodeinTags
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val verificationModule = DI.Module("verification") {

    bind() from provider {
        @Suppress("UNCHECKED_CAST") val factory = object : ViewModelProvider.Factory {

            val loginServiceInteractor = LoginServiceInteractor(
                service = instance()
            )

            override fun <VM : ViewModel> create(klass: Class<VM>) =
                VerificationViewModel(loginServiceInteractor) as VM
        }

        val host: FragmentActivity = instance(KodeinTags.hostActivity)
        ViewModelProvider(host, factory).get(VerificationViewModel::class.java)
    }
}
