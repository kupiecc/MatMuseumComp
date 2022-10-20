package net.jackapp.matmuseumcomp.presentation.viewmodels

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import net.jackapp.matmuseumcomp.data.json.*
import net.jackapp.matmuseumcomp.data.viewdata.MuseumViewData
import net.jackapp.matmuseumcomp.domain.usecase.GetFirstItemUseCase
import net.jackapp.matmuseumcomp.domain.usecase.GetSummaryUseCase
import net.jackapp.matmuseumcomp.domain.usecase.MuseumUseCases
import net.jackapp.matmuseumcomp.factory.TestDataFactory.createMuseumItem
import net.jackapp.matmuseumcomp.factory.TestDataFactory.createMuseumSummary
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class MuseumViewModelTest {

    private lateinit var useCase: MuseumUseCases
    private lateinit var firstItemUseCase: GetFirstItemUseCase
    private lateinit var summaryUseCase: GetSummaryUseCase

    private lateinit var subject: MuseumViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    private val dispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        firstItemUseCase = mockk()
        summaryUseCase = mockk()
        useCase = MuseumUseCases(firstItemUseCase, summaryUseCase)
        subject = MuseumViewModel(useCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given MuseumViewModel, When getMuseumItem is calling, Then museumItemFlow should emit`() =
        runTest {
            val museumItem = createMuseumItem()
            val itemResult = MuseumViewData.SuccessItem(museumItem)
            coEvery { useCase.getFirstItemUseCase() } returns itemResult
            val job = launch(start = CoroutineStart.LAZY) {
                subject.getMuseumItem()
            }

            subject.museumItemFlow.test {
                job.start()
                val item = awaitItem()
                assertThat(item, equalTo(itemResult))
                cancelAndConsumeRemainingEvents()
            }
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given MuseumViewModel, When getMuseumSummary is calling, Then museumSummaryFlow should emit`() =
        runTest {
            val museumSummary = createMuseumSummary()
            val summaryResult = MuseumViewData.SuccessSummary(museumSummary)
            coEvery { useCase.getSummaryUseCase() } returns summaryResult
            val job = launch(start = CoroutineStart.LAZY) {
                subject.getMuseumSummary()
            }

            subject.museumSummaryFlow.test {
                job.start()
                val summary = awaitItem()
                assertThat(summary, equalTo(summaryResult))
                cancelAndConsumeRemainingEvents()
            }
        }
}