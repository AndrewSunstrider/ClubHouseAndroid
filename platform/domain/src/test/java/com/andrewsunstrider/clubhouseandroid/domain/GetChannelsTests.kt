package com.andrewsunstrider.clubhouseandroid.domain


import com.andrewsunstrider.clubhouseandroid.domain.model.Channel
import com.andrewsunstrider.clubhouseandroid.domain.services.ChannelsService
import com.andrewsunstrider.clubhouseandroid.domain.usecase.GetChannels
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test


class GetChannelsTests {

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
    fun `get channels data from remote`() {
        runBlocking {
            val input = usecase.getChannels()
            val output = channelsData
            assertThat(input).isEqualTo(output)
        }
    }
}