package com.andrewsunstrider.clubhouseandroid.auth.auth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.andrewsunstrider.clubhouseandroid.auth.R
import com.andrewsunstrider.clubhouseandroid.auth.databinding.ActivityAuthBinding
import com.andrewsunstrider.clubhouseandroid.auth.databinding.ActivityAuthBinding.inflate
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

        initListeners()

        lifecycleScope.launch {
            delay(1000)
            viewModel.bind().collect { render(it) }
        }
    }

    private fun render(state: AuthScreenState) {
        when (state) {
            AuthScreenState.Idle -> launch()
            // TODO: 26.03.2021 Replace logger.i on logger.d
            AuthScreenState.Success -> logger.i("Success -> Auth Activity running.")
            is AuthScreenState.Failed -> logger.e("Error -> ${state.reason}")
            AuthScreenState.ShowVerification -> proceedToVerification()
            else -> throw IllegalArgumentException("Unknown type for $state.")
        }
    }

    private fun launch() {
        viewModel.handleApplicationLaunch()
    }

    private fun initListeners() {
        val nextBtn = findViewById<Button>(R.id.auth_next_btn)

        nextBtn.setOnClickListener {
            viewModel.getAuth(getCleanPhoneNumber())
            logger.i("Number is ${getCleanPhoneNumber()}")
        }
    }

    private fun getCleanPhoneNumber(): String {
        val phoneInput = findViewById<EditText>(R.id.phone_number_field)

        val number = phoneInput.text.toString().replace("[^\\d]".toRegex(), "")
        return "+$number"
    }

    private fun proceedToVerification() {
        navigator.navigateTo(Screen.Verification)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}
