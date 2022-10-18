package net.jackapp.matmuseumcomp.domain.usecase

import net.jackapp.matmuseumcomp.data.viewdata.MuseumViewData
import net.jackapp.matmuseumcomp.data.response.ResourceResponse
import net.jackapp.matmuseumcomp.domain.repositories.MuseumRepository

class GetSummaryUseCase(
    private val museumRepository: MuseumRepository
) {

    suspend operator fun invoke(): MuseumViewData {
        return when (val allIds = museumRepository.fetchAllIds()) {
            is ResourceResponse.Success ->
                MuseumViewData.SuccessSummary(allIds.data!!)
            is ResourceResponse.Error ->
                MuseumViewData.Error(allIds.message!!)
        }
    }
}