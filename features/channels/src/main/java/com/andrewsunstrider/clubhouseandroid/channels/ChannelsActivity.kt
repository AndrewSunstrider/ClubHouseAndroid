package com.andrewsunstrider.clubhouseandroid.channels

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.andrewsunstrider.clubhouseandroid.channels.databinding.ActivityChannelsBinding
import com.andrewsunstrider.clubhouseandroid.logger.Logger
import com.andrewsunstrider.clubhouseandroid.navigator.Navigator
import com.andrewsunstrider.clubhouseandroid.utilities.selfBind
import com.andrewsunstrider.clubhouseandroid.utilities.viewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.kodein.di.DIAware
import org.kodein.di.instance

class ChannelsActivity : AppCompatActivity(), DIAware {

    override val di by selfBind()

    private val viewBindings by viewBinding(ActivityChannelsBinding::inflate)
    private val logger by instance<Logger>()
    private val navigator by instance<Navigator>()
    private val viewModel by instance<ChannelsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBindings.root)

        lifecycleScope.launch {
            delay(1000)
            viewModel.bind().collect { render(it) }
        }
    }

    private fun render(state: ChannelsScreenState) {
        when (state) {
            ChannelsScreenState.Idle -> launch()
            is ChannelsScreenState.Success -> {
                showChannels(state.value)
                logger.i("Success -> Channels Activity running.")
            }
            is ChannelsScreenState.Failed -> logger.e("Error -> ${state.reason}")
            else -> throw IllegalArgumentException("Unknown type for $state.")
        }
    }

    private fun launch() {
        viewModel.handleApplicationLaunch()
    }

    private fun showChannels(presentation: List<ChannelDisplayRow>) {
        viewBindings.run {
            channelsRv.adapter = ChannelsAdapter(presentation) {}
        }
    }
}
