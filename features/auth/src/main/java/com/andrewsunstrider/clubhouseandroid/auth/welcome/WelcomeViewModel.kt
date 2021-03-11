package com.andrewsunstrider.clubhouseandroid.auth.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {

    private val states = MutableStateFlow<WelcomeScreenState>(WelcomeScreenState.Idle)

    fun bind() = states.asStateFlow()

    fun handleApplicationLaunch() {
        viewModelScope.launch {
            states.value = WelcomeScreenState.Launching
            try {
                states.value = WelcomeScreenState.Success
            } catch (_: Throwable) {
                states.value = WelcomeScreenState.Failed
            }
        }
    }
}
