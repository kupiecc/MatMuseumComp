package net.jackapp.matmuseumcomp.usecase

import net.jackapp.matmuseumcomp.data.resultdata.MuseumItemResult
import net.jackapp.matmuseumcomp.data.resultdata.MuseumSummaryResult
import net.jackapp.matmuseumcomp.data.resultdata.MuseumViewData
import net.jackapp.matmuseumcomp.repositories.MuseumRepository

class GetItemUseCase(
    private val museumRepository: MuseumRepository
) {

    suspend fun getFirstAvailableItem(): MuseumViewData {
        return when (val result = museumRepository.fetchAllIds()) {
            is MuseumSummaryResult.Summary -> {
                val firstId = result.summary.objectIDs.minOf { it }
                when (val firstItem = museumRepository.fetchItemById(firstId.toString())) {
                    is MuseumItemResult.Item -> MuseumViewData.Success(items = listOf(firstItem.item))
                    is MuseumItemResult.Error -> MuseumViewData.Error(message = firstItem.message)
                }
            }
            is MuseumSummaryResult.Error ->
                MuseumViewData.Error(result.message)
        }
    }

    suspend fun getLastAvailableItem(): MuseumViewData {
        return when (val result = museumRepository.fetchAllIds()) {
            is MuseumSummaryResult.Summary -> {
                val firstId = result.summary.objectIDs.maxOf { it }
                when (val firstItem = museumRepository.fetchItemById(firstId.toString())) {
                    is MuseumItemResult.Item -> MuseumViewData.Success(items = listOf(firstItem.item))
                    is MuseumItemResult.Error -> MuseumViewData.Error(message = firstItem.message)
                }
            }
            is MuseumSummaryResult.Error ->
                MuseumViewData.Error(result.message)
        }
    }

}