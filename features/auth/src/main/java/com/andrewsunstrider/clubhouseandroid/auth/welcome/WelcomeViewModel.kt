package com.andrewsunstrider.clubhouseandroid.auth.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrewsunstrider.clubhouseandroid.domain.usecase.IsLogged
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val isLogged: IsLogged
) : ViewModel() {

    private val states = MutableStateFlow<WelcomeScreenState>(WelcomeScreenState.Idle)

    fun bind() = states.asStateFlow()

    fun handleApplicationLaunch() {
        viewModelScope.launch {
            states.value = WelcomeScreenState.Launching
            try {
                //I don't use it there, left it here as example how to work with states of the following activities.

                states.value = WelcomeScreenState.Success
            } catch (error: Throwable) {
                states.value = WelcomeScreenState.Failed(error)
            }
        }
    }

    fun isUserLogged() {
        viewModelScope.launch {
            try {
                isLogged.execute().apply {
                    states.value = if (this) WelcomeScreenState.ShowChannelsScreen
                    else WelcomeScreenState.ShowRegistrationScreen
                }
            } catch (error: Throwable) {
                states.value = WelcomeScreenState.Failed(error)
            }
        }
    }
}
