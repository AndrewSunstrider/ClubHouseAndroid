//package com.andrewsunstrider.clubhouseandroid.auth
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.lifecycleScope
//import com.andrewsunstrider.clubhouseandroid.logger.Logger
//import com.andrewsunstrider.clubhouseandroid.navigator.Navigator
//import com.andrewsunstrider.clubhouseandroid.navigator.Screen
//import com.andrewsunstrider.clubhouseandroid.utilities.selfBind
//import com.andrewsunstrider.clubhouseandroid.utilities.viewBinding
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import org.kodein.di.DIAware
//import org.kodein.di.instance
//import android.R.anim.fade_in as FadeIn
//import android.R.anim.fade_out as FadeOut
//
//class AuthActivity : AppCompatActivity(), DIAware {
//
//    override val di by selfBind()
//
//    private val viewBindings by viewBinding(ActivityAuthBinding::inflate)
//    private val logger by instance<Logger>()
//    private val navigator by instance<Navigator>()
//    private val viewModel by instance<AuthViewModel>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(viewBindings.root)
//
//        lifecycleScope.launch {
//            delay(1000)
//            viewModel.bind().collect { render(it) }
//        }
//    }
//
//    private fun render(state: OnboardingScreenState) {
//        when (state) {
//            Idle -> launch()
//            Success -> {
//                logger.i("Success -> Categories fetched, proceding to facts")
//                proceedToFacts()
//            }
//            Failed -> {
//                logger.e("Error -> $state")
//                proceedToFacts()
//            }
//        }
//    }
//
//    private fun launch() {
//        viewModel.handleApplicationLaunch()
//    }
//
//    private fun proceedToFacts() {
//        navigator.navigateTo(Screen.Auth)
//        overridePendingTransition(FadeIn, FadeOut)
//        finish()
//    }
//}
