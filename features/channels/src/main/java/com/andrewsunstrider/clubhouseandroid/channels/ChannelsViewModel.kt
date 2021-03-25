package com.andrewsunstrider.clubhouseandroid.channels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrewsunstrider.clubhouseandroid.domain.GetChannels
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChannelsViewModel(
    private val getChannels: GetChannels
) : ViewModel() {

    private val states = MutableStateFlow<ChannelsScreenState>(ChannelsScreenState.Idle)

    fun bind() = states.asStateFlow()

    fun handleApplicationLaunch() {
        viewModelScope.launch {
            states.value = ChannelsScreenState.Launching
            try {
                states.value = ChannelsScreenState.Success(getChannels())
            } catch (error: Throwable) {
                states.value = ChannelsScreenState.Failed(error)
            }
        }
    }

    private suspend fun getChannels(): List<ChannelDisplayRow> = getChannels.getChannels().map {
        ChannelDisplayRow(it)
    }
}
