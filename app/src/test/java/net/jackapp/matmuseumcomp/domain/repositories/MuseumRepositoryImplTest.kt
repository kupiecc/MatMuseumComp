package net.jackapp.matmuseumcomp.domain.repositories

import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import net.jackapp.matmuseumcomp.data.response.ResourceResponse
import net.jackapp.matmuseumcomp.domain.helper.RetrofitHelper
import net.jackapp.matmuseumcomp.factory.TestDataFactory
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

internal class MuseumRepositoryImplTest {

    private val retrofitHelper: RetrofitHelper = mockk()
    private val subject by lazy { MuseumRepositoryImpl(retrofitHelper) }

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
    fun `Given MuseumRepository, When fetchItemById is calling, Then ResourceResponse Success should be returned`() =
        runTest {
            val museumItem = TestDataFactory.createMuseumItem()
            val itemResponse = ResourceResponse.Success(museumItem)

            coEvery { retrofitHelper.callMuseumApi().getObject("1").body() } returns museumItem

            val result = subject.fetchItemById("1")

            Truth.assertThat(result).isInstanceOf(ResourceResponse.Success::class.java)
            Truth.assertThat((result as ResourceResponse.Success).data).isEqualTo(itemResponse.data)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given MuseumRepository, When fetchItemById is calling but retrofit return null, Then ResourceResponse Error with message should be returned`() =
        runTest {
            coEvery { retrofitHelper.callMuseumApi().getObject("1").body() } returns null

            val result = subject.fetchItemById("1")

            Truth.assertThat(result).isInstanceOf(ResourceResponse.Error::class.java)
            Truth.assertThat((result as ResourceResponse.Error).message).isEqualTo("Huston! We have a problem!")
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given MuseumRepository, When fetchItemById is calling but Exception thrown, Then ResourceResponse Error with message should be returned`() =
        runTest {
            val errorMessage = "error message"
            val error = IOException(errorMessage)
            coEvery { retrofitHelper.callMuseumApi().getObject("1").body() } throws(IOException(error))

            val result = subject.fetchItemById("1")

            Truth.assertThat(result).isInstanceOf(ResourceResponse.Error::class.java)
            Truth.assertThat((result as ResourceResponse.Error).message).isEqualTo("java.io.IOException: $errorMessage")
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given MuseumRepository, When fetchAllIds is calling, Then ResourceResponse Success should be returned`() =
        runTest {
            val museumSummary = TestDataFactory.createMuseumSummary()
            val itemResponse = ResourceResponse.Success(museumSummary)

            coEvery { retrofitHelper.callMuseumApi().getAllIds().body() } returns museumSummary

            val result = subject.fetchAllIds()

            Truth.assertThat(result).isInstanceOf(ResourceResponse.Success::class.java)
            Truth.assertThat((result as ResourceResponse.Success).data).isEqualTo(itemResponse.data)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given MuseumRepository, When fetchAllIds is calling but retrofit return null, Then ResourceResponse Error with message should be returned`() =
        runTest {
            coEvery { retrofitHelper.callMuseumApi().getAllIds().body() } returns null

            val result = subject.fetchAllIds()

            Truth.assertThat(result).isInstanceOf(ResourceResponse.Error::class.java)
            Truth.assertThat((result as ResourceResponse.Error).message).isEqualTo("Huston! We have a problem!")
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Given MuseumRepository, When fetchAllIds is calling but Exception thrown, Then ResourceResponse Error with message should be returned`() =
        runTest {
            val errorMessage = "error message"
            val error = IOException(errorMessage)
            coEvery { retrofitHelper.callMuseumApi().getAllIds().body() } throws(IOException(error))

            val result = subject.fetchAllIds()

            Truth.assertThat(result).isInstanceOf(ResourceResponse.Error::class.java)
            Truth.assertThat((result as ResourceResponse.Error).message).isEqualTo("java.io.IOException: $errorMessage")
        }

}