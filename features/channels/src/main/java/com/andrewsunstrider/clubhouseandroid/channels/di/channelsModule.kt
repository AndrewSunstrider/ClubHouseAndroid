package com.andrewsunstrider.clubhouseandroid.channels.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andrewsunstrider.clubhouseandroid.channels.ChannelsViewModel
import com.andrewsunstrider.clubhouseandroid.utilities.KodeinTags
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val channelsModule = DI.Module("channels") {

    bind() from provider {
        @Suppress("UNCHECKED_CAST") val factory = object : ViewModelProvider.Factory {

            override fun <VM : ViewModel> create(klass: Class<VM>) =
                ChannelsViewModel() as VM
        }

        val host: FragmentActivity = instance(KodeinTags.hostActivity)
        ViewModelProvider(host, factory).get(ChannelsViewModel::class.java)
    }
}
