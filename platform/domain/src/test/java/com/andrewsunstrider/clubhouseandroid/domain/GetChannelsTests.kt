package com.andrewsunstrider.clubhouseandroid.domain


import com.andrewsunstrider.clubhouseandroid.domain.services.ChannelsService
import com.andrewsunstrider.clubhouseandroid.domain.usecase.GetChannels
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test


class GetChannelsTests {

    private val channelsData = ChannelFactory.makeChannels()

    @MockK
    lateinit var channelService: ChannelsService
    private lateinit var usecase: GetChannels

    @Before
    fun `before each test`() {
        MockKAnnotations.init(this)
        usecase = GetChannels(channelService)
    }

    @Test
    fun `get channels data from remote`() {
        runBlocking {
            val output = usecase.getChannels()
            val input = channelsData

            assertThat(output).isEqualTo(input)
        }
    }
}