package com.andrewsunstrider.clubhouseandroid.channels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChannelsViewModel : ViewModel() {

    private val states = MutableStateFlow<ChannelsScreenState>(ChannelsScreenState.Idle)

    fun bind() = states.asStateFlow()

    fun handleApplicationLaunch() {
        viewModelScope.launch {
            states.value = ChannelsScreenState.Launching
            try {
                //I don't use it there, left it here as example how to work with states of the following activities.
                states.value = ChannelsScreenState.Success
            } catch (error: Throwable) {
                states.value = ChannelsScreenState.Failed(error)
            }
        }
    }
}
