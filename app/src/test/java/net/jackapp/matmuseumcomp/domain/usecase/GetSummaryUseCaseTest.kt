package net.jackapp.matmuseumcomp.domain.usecase

import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import net.jackapp.matmuseumcomp.data.json.MuseumSummary
import net.jackapp.matmuseumcomp.data.response.ResourceResponse
import net.jackapp.matmuseumcomp.data.viewdata.MuseumViewData
import net.jackapp.matmuseumcomp.domain.repositories.MuseumRepository
import net.jackapp.matmuseumcomp.factory.TestDataFactory
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class GetSummaryUseCaseTest {

    private val museumRepository: MuseumRepository = mockk()
    private val subject by lazy { GetSummaryUseCase(museumRepository) }

    @OptIn(ExperimentalCoroutinesApi::class)
    private val dispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given GetSummaryUseCase, When invoke is calling, Then MuseumViewData Success should be returned`() =
        runTest {
            val allIds = TestDataFactory.createMuseumSummary()
            val allIdsResponse = ResourceResponse.Success(allIds)
            val summaryViewData = MuseumViewData.SuccessSummary(allIds)
            coEvery { museumRepository.fetchAllIds() } returns allIdsResponse

            val result = subject.invoke()

            Truth.assertThat(result).isInstanceOf(MuseumViewData.SuccessSummary::class.java)
            Truth.assertThat((result as MuseumViewData.SuccessSummary).summary).isEqualTo(summaryViewData.summary)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given GetSummaryUseCase, When invoke is calling and fetchAllIds return Error, Then MuseumViewData Error should be returned`() =
        runTest {
            val errorMessage = "error message"
            val allIdsResponse = ResourceResponse.Error<MuseumSummary>(errorMessage)
            val summaryViewData = MuseumViewData.Error(errorMessage)
            coEvery { museumRepository.fetchAllIds() } returns allIdsResponse

            val result = subject.invoke()

            Truth.assertThat(result).isInstanceOf(MuseumViewData.Error::class.java)
            Truth.assertThat((result as MuseumViewData.Error).message).isEqualTo(summaryViewData.message)
        }
}