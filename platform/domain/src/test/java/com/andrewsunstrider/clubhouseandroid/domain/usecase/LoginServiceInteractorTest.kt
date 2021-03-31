package com.andrewsunstrider.clubhouseandroid.domain.usecase

import com.andrewsunstrider.clubhouseandroid.domain.AuthorisationProvider
import com.andrewsunstrider.clubhouseandroid.domain.factory.AuthorisationFactory
import com.andrewsunstrider.clubhouseandroid.domain.factory.DomainDataFactory
import com.andrewsunstrider.clubhouseandroid.domain.services.AuthService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LoginServiceInteractorTest {

    @MockK
    lateinit var service: AuthService

    @MockK(relaxed = true)
    lateinit var authorisationProvider: AuthorisationProvider

    private lateinit var usecase: LoginServiceInteractor

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        usecase = LoginServiceInteractor(
            service = service,
            authorisationProvider = authorisationProvider
        )
    }

    @Test
    fun sendNumber() {
    }

    @Test
    fun `sendCode, should return success`() = runBlocking {
        val response = AuthorisationFactory.makeAuthorisation()
        val verificationCode = DomainDataFactory.randomString()
        val phoneNumber = DomainDataFactory.randomString()

        coEvery {
            service.sendCode(
                verificationCode = verificationCode,
                phoneNumber = phoneNumber
            )
        } returns response

        coEvery {
            authorisationProvider.getPhoneNumber()
        } returns phoneNumber

        usecase.sendCode(verificationCode)

        assertEquals(authorisationProvider.getUserID(), response.userProfile.userId.toString())
        assertEquals(authorisationProvider.getUserToken(), response.authToken)
        assertEquals(authorisationProvider.isWaitlisted(), response.isWaitlisted)
    }
}