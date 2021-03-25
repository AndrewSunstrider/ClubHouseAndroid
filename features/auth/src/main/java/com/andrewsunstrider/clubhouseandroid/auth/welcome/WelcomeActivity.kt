package com.andrewsunstrider.clubhouseandroid.auth.welcome

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.andrewsunstrider.clubhouseandroid.auth.R
import com.andrewsunstrider.clubhouseandroid.auth.databinding.ActivityWelcomeBinding
import com.andrewsunstrider.clubhouseandroid.logger.Logger
import com.andrewsunstrider.clubhouseandroid.navigator.Navigator
import com.andrewsunstrider.clubhouseandroid.navigator.Screen
import com.andrewsunstrider.clubhouseandroid.utilities.selfBind
import com.andrewsunstrider.clubhouseandroid.utilities.viewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.kodein.di.DIAware
import org.kodein.di.instance

class WelcomeActivity : AppCompatActivity(), DIAware {

    override val di by selfBind()

    private val viewBindings by viewBinding(ActivityWelcomeBinding::inflate)
    private val logger by instance<Logger>()
    private val navigator by instance<Navigator>()
    private val viewModel by instance<WelcomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBindings.root)

        initListeners()

        lifecycleScope.launch {
            delay(1000)
            viewModel.bind().collect { render(it) }
        }
    }

    private fun render(state: WelcomeScreenState) {
        when (state) {
            WelcomeScreenState.Idle -> launch()
            WelcomeScreenState.Success -> logger.d("Success -> Welcome Activity running.")
            WelcomeScreenState.ShowRegistrationScreen -> proceedToAuth()
            WelcomeScreenState.ShowChannelsScreen -> proceedToChannels()
            is WelcomeScreenState.Failed -> logger.e("Error -> ${state.error}")
            else -> throw IllegalArgumentException("Unknown type for $state.")
        }
    }

    private fun launch() {
        viewModel.handleApplicationLaunch()
    }

    private fun initListeners() {
        val gotItBtn = findViewById<Button>(R.id.welcome_button)
        gotItBtn.setOnClickListener { checkIsLogged() }
    }

    private fun checkIsLogged() {
        viewModel.isUserLogged()
    }

    private fun proceedToChannels() {
        navigator.navigateTo(Screen.Channels)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    private fun proceedToAuth() {
        navigator.navigateTo(Screen.Auth)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}