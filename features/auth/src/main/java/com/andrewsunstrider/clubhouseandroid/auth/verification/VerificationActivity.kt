package com.andrewsunstrider.clubhouseandroid.auth.verification

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.andrewsunstrider.clubhouseandroid.auth.R
import com.andrewsunstrider.clubhouseandroid.auth.databinding.ActivityVerificationBinding
import com.andrewsunstrider.clubhouseandroid.logger.Logger
import com.andrewsunstrider.clubhouseandroid.navigator.Navigator
import com.andrewsunstrider.clubhouseandroid.utilities.selfBind
import com.andrewsunstrider.clubhouseandroid.utilities.viewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.kodein.di.DIAware
import org.kodein.di.instance

class VerificationActivity : AppCompatActivity(), DIAware {

    override val di by selfBind()

    private val viewBindings by viewBinding(ActivityVerificationBinding::inflate)
    private val logger by instance<Logger>()
    private val navigator by instance<Navigator>()
    private val viewModel by instance<VerificationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBindings.root)

        initListeners()

        lifecycleScope.launch {
            delay(1000)
            viewModel.bind().collect { render(it) }
        }
    }

    private fun render(state: VerificationScreenState) {
        when (state) {
            VerificationScreenState.Idle -> launch()
            VerificationScreenState.Success -> {
                logger.i("Success -> Verification Activity running.")
            }
            is VerificationScreenState.Failed -> {
                logger.e("Error -> ${state.error}")
            }
            is VerificationScreenState.ShowChannelsScreen -> {
                logger.i("Time to show Channel list screen!")
                // TODO: 24.03.2021 show next screen
            }
            else -> throw IllegalArgumentException("Unknown type for $state.")
        }
    }

    private fun launch() {
        viewModel.handleApplicationLaunch()
    }

    private fun getVerificationCode(): String {
        val codeInput = findViewById<EditText>(R.id.verification_field)

        return codeInput.text.toString()
    }

    private fun initListeners() {
        val nextBtn = findViewById<Button>(R.id.verification_next_btn)

        nextBtn.setOnClickListener {
            viewModel.getVerification(getVerificationCode())
        }
    }
}