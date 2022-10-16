package net.jackapp.matmuseumcomp.usecase

import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.resultdata.MuseumSummaryResult
import net.jackapp.matmuseumcomp.data.resultdata.MuseumViewData
import net.jackapp.matmuseumcomp.repositories.MuseumRepository

class MuseumStatisticsUseCase(
    private val museumRepository: MuseumRepository
) {

    suspend fun getAllItemsCount(): MuseumViewData {
        return when (val result = museumRepository.fetchAllIds()) {
            is MuseumSummaryResult.Summary ->
                MuseumViewData.SummarySuccess(result.summary.objectIDs.size)
            is MuseumSummaryResult.Error ->
                MuseumViewData.Error(result.message)
        }
    }

}