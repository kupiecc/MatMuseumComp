package net.jackapp.matmuseumcomp.domain.usecase

import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.json.MuseumSummary
import net.jackapp.matmuseumcomp.data.response.ResourceResponse
import net.jackapp.matmuseumcomp.data.viewdata.MuseumViewData
import net.jackapp.matmuseumcomp.domain.repositories.MuseumRepository
import net.jackapp.matmuseumcomp.factory.TestDataFactory
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class GetFirstItemUseCaseTest {

    private val museumRepository: MuseumRepository = mockk()
    private val subject by lazy { GetFirstItemUseCase(museumRepository) }

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
    fun `Given GetFirstItemUseCase, When invoke is calling, Then MuseumViewData Success should be returned`() =
        runTest {
            val allIds = TestDataFactory.createMuseumSummary()
            val item = TestDataFactory.createMuseumItem()
            val allIdsResponse = ResourceResponse.Success(allIds)
            val itemResponse = ResourceResponse.Success(item)
            val itemViewData = MuseumViewData.SuccessItem(item)
            coEvery { museumRepository.fetchAllIds() } returns allIdsResponse
            coEvery { museumRepository.fetchItemById("1") } returns itemResponse

            val result = subject.invoke()

            assertThat(result).isInstanceOf(MuseumViewData.SuccessItem::class.java)
            assertThat((result as MuseumViewData.SuccessItem).item).isEqualTo(itemViewData.item)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given GetFirstItemUseCase, When invoke is calling but allIds return Error, Then MuseumViewData Error should be returned`() =
        runTest {
            val errorMessage = "error message"
            val item = TestDataFactory.createMuseumItem()
            val allIdsResponse = ResourceResponse.Error<MuseumSummary>(errorMessage)
            val itemResponse = ResourceResponse.Success(item)
            coEvery { museumRepository.fetchAllIds() } returns allIdsResponse
            coEvery { museumRepository.fetchItemById("1") } returns itemResponse

            val result = subject.invoke()

            assertThat(result).isInstanceOf(MuseumViewData.Error::class.java)
            assertThat((result as MuseumViewData.Error).message).isEqualTo(allIdsResponse.message)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given GetFirstItemUseCase, When invoke is calling, allIds return Success but fetchItemById return Error, Then MuseumViewData Error should be returned`() =
        runTest {
            val errorMessage = "error message"
            val allIds = TestDataFactory.createMuseumSummary()
            val allIdsResponse = ResourceResponse.Success(allIds)
            val itemResponse = ResourceResponse.Error<MuseumItem>(errorMessage)
            coEvery { museumRepository.fetchAllIds() } returns allIdsResponse
            coEvery { museumRepository.fetchItemById("1") } returns itemResponse

            val result = subject.invoke()

            assertThat(result).isInstanceOf(MuseumViewData.Error::class.java)
            assertThat((result as MuseumViewData.Error).message).isEqualTo(itemResponse.message)
        }
}