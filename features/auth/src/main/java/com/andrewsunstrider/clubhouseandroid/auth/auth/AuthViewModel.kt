package com.andrewsunstrider.clubhouseandroid.auth.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrewsunstrider.clubhouseandroid.domain.LoginServiceInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val loginServiceInteractor: LoginServiceInteractor
) : ViewModel() {

    private val states = MutableStateFlow<AuthScreenState>(AuthScreenState.Idle)

    fun bind() = states.asStateFlow()

    fun handleApplicationLaunch() {
        viewModelScope.launch {
            states.value = AuthScreenState.Launching
            try {
                //I don't use it there, left it here as example how to work with states of the following activities.
                states.value = AuthScreenState.Success
            } catch (_: Throwable) {
                states.value = AuthScreenState.Failed
            }
        }
    }

    fun getAuth(phoneNumber: String) =
        viewModelScope.launch {
            loginServiceInteractor.sendNumber(phoneNumber)
        }
}
