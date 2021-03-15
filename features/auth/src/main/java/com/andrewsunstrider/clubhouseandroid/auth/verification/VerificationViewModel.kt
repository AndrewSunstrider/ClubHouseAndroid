package com.andrewsunstrider.clubhouseandroid.auth.verification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VerificationViewModel : ViewModel() {

    private val states = MutableStateFlow<VerificationScreenState>(VerificationScreenState.Idle)

    fun bind() = states.asStateFlow()

    fun handleApplicationLaunch() {
        viewModelScope.launch {
            states.value = VerificationScreenState.Launching
            try {
                //I don't use it there, left it here as example how to work with states of the following activities.
                states.value = VerificationScreenState.Success
            } catch (_: Throwable) {
                states.value = VerificationScreenState.Failed
            }
        }
    }
}
