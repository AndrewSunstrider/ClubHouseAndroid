package com.andrewsunstrider.clubhouseandroid.auth.auth

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.andrewsunstrider.clubhouseandroid.auth.R
import com.andrewsunstrider.clubhouseandroid.auth.databinding.ActivityAuthBinding
import com.andrewsunstrider.clubhouseandroid.auth.databinding.ActivityAuthBinding.inflate
import com.andrewsunstrider.clubhouseandroid.auth.databinding.ActivityWelcomeBinding
import com.andrewsunstrider.clubhouseandroid.auth.welcome.WelcomeScreenState
import com.andrewsunstrider.clubhouseandroid.auth.welcome.WelcomeViewModel
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

class AuthActivity : AppCompatActivity(), DIAware {

    override val di by selfBind()

    private val viewBindings by viewBinding(ActivityAuthBinding::inflate)
    private val logger by instance<Logger>()
    private val navigator by instance<Navigator>()
    private val viewModel by instance<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBindings.root)

        lifecycleScope.launch {
            delay(1000)
            viewModel.bind().collect { render(it) }
        }
    }

    private fun render(state: AuthScreenState) {
        when (state) {
            AuthScreenState.Idle -> launch()
            AuthScreenState.Success -> {
                logger.i("Success -> Welcome Activity running.")
            }
            AuthScreenState.Failed -> {
                logger.e("Error -> $state.")
            }
            else -> throw IllegalArgumentException("Unknown type for $state.")
        }
    }

    private fun launch() {
        viewModel.handleApplicationLaunch()
    }
}
