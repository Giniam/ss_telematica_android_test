package com.example.sstelematicaandroidtest.presentation.features.user.details

import com.example.sstelematicaandroidtest.domain.common.Result
import com.example.sstelematicaandroidtest.domain.usecase.GetRepositoriesFromUserUseCase
import com.example.sstelematicaandroidtest.util.CoroutineTestRule
import com.example.sstelematicaandroidtest.util.TestData.FIRST_REPO
import com.example.sstelematicaandroidtest.util.TestData.FIRST_REPO_PRESENTATION
import com.example.sstelematicaandroidtest.util.TestData.FIRST_USER_PRESENTATION
import com.example.sstelematicaandroidtest.util.TestData.SECOND_REPO
import com.example.sstelematicaandroidtest.util.TestData.SECOND_REPO_PRESENTATION
import com.example.sstelematicaandroidtest.util.initMockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
class UserDetailViewModelTest {

    @get:Rule
    @ExperimentalCoroutinesApi
    val coroutineTestRule = CoroutineTestRule()

    private val unconfinedTestDispatcher = UnconfinedTestDispatcher()

    @RelaxedMockK
    private lateinit var getRepositoriesFromUserUseCase: GetRepositoriesFromUserUseCase

    @InjectMockKs
    private lateinit var userDetailViewModel: UserDetailViewModel

    init {
        initMockKAnnotations()
    }

    @Test
    fun `GIVEN getRepositoriesFromUserUseCase returns list WHEN fetchAllUsers called THEN must set fetchUsersState with same list`() =
        runTest(unconfinedTestDispatcher) {
            // GIVEN
            val user = FIRST_USER_PRESENTATION
            coEvery { getRepositoriesFromUserUseCase(user.login) } returns Result.Success(
                listOf(FIRST_REPO, SECOND_REPO)
            )
            val expected = Fetched(listOf(FIRST_REPO_PRESENTATION, SECOND_REPO_PRESENTATION))

            // WHEN
            userDetailViewModel.fetchRepositoriesFromUser(user)

            // THEN
            Assert.assertEquals(expected, userDetailViewModel._fetchRepositoriesState.value)
        }

    @Test
    fun `GIVEN getRepositoriesFromUserUseCase returns error WHEN fetchAllUsers called THEN must set fetchUsersState with error`() =
        runTest(unconfinedTestDispatcher) {
            // GIVEN
            val user = FIRST_USER_PRESENTATION
            val throwable = Throwable("Message")
            coEvery { getRepositoriesFromUserUseCase(user.login) } returns Result.Error(throwable)
            val expected = Error(throwable)

            // WHEN
            userDetailViewModel.fetchRepositoriesFromUser(user)

            // THEN
            Assert.assertEquals(expected, userDetailViewModel._fetchRepositoriesState.value)
        }

    @Test
    fun `GIVEN getRepositoriesFromUserUseCase returns empty list WHEN fetchAllUsers called THEN must set fetchUsersState with EmptyList`() =
        runTest(unconfinedTestDispatcher) {
            // GIVEN
            val user = FIRST_USER_PRESENTATION
            coEvery { getRepositoriesFromUserUseCase(user.login) } returns Result.Success(emptyList())
            val expected = EmptyList

            // WHEN
            userDetailViewModel.fetchRepositoriesFromUser(user)

            // THEN
            Assert.assertEquals(expected, userDetailViewModel._fetchRepositoriesState.value)
        }
}