package net.jackapp.matmuseumcomp.domain.usecase

import net.jackapp.matmuseumcomp.data.json.MuseumSummary
import net.jackapp.matmuseumcomp.data.response.ResourceResponse
import net.jackapp.matmuseumcomp.data.viewdata.MuseumViewData
import net.jackapp.matmuseumcomp.domain.repositories.MuseumRepository

open class GetFirstItemUseCase(
    private val museumRepository: MuseumRepository
) {

    suspend operator fun invoke(): MuseumViewData {
        museumRepository.fetchAllIds().let { allIds ->
           return when(allIds) {
                is ResourceResponse.Error ->
                    MuseumViewData.Error(allIds.message!!)
                is ResourceResponse.Success -> {
                    findFirsItem(allIds)
                }
            }
        }

    }

    private suspend fun findFirsItem(allIds: ResourceResponse<MuseumSummary>): MuseumViewData {
        val firstId = allIds.data?.objectIDs?.minOfOrNull { it }
        return when (val firstItem = museumRepository.fetchItemById(firstId.toString())) {
            is ResourceResponse.Success ->
                MuseumViewData.SuccessItem(firstItem.data!!)
            is ResourceResponse.Error ->
                MuseumViewData.Error(firstItem.message!!)
        }
    }
}