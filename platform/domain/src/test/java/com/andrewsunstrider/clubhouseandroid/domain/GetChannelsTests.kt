package com.andrewsunstrider.clubhouseandroid.domain


import com.andrewsunstrider.clubhouseandroid.domain.errors.NetworkingError
import com.andrewsunstrider.clubhouseandroid.domain.model.Channel
import com.andrewsunstrider.clubhouseandroid.domain.services.ChannelsService
import com.andrewsunstrider.clubhouseandroid.domain.usecase.GetChannels
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test


class GetChannelsTests {

    private lateinit var channelsService: ChannelsService

    private val channelsData = ChannelFactory.makeChannels()

    private lateinit var usecase: GetChannels

    class FakeChannelsService(
        private val fakeChannels: List<Channel>
    ) : ChannelsService {

        override suspend fun availableChannels(): List<Channel> = fakeChannels
    }

    @Before
    fun `before each test`() {
        val service = FakeChannelsService(channelsData)
        usecase = GetChannels(service)
    }

    @Test
    fun `should fetch from remote`() {
        runBlocking {
            `given that remote service returns channels`()
            `given that remote service not available`()

            val usecase = GetChannels(channelsService)

            assertThat(usecase.getChannels()).isEqualTo(channelsData)
        }
    }

    private fun `given that remote service returns channels`() {
        channelsService = object : ChannelsService {
            override suspend fun availableChannels(): List<Channel> = channelsData
        }
    }

    private fun `given that remote service not available`() {
        channelsService = object : ChannelsService {
            override suspend fun availableChannels(): List<Channel> {
                throw NetworkingError.HostUnreachable
            }
        }
    }
}