package net.jackapp.matmuseumcomp.domain.usecase

import net.jackapp.matmuseumcomp.data.response.ResourceResponse
import net.jackapp.matmuseumcomp.data.viewdata.MuseumViewData
import net.jackapp.matmuseumcomp.domain.repositories.MuseumRepository

open class GetFirstItemUseCase(
    private val museumRepository: MuseumRepository
) {

    suspend operator fun invoke(): MuseumViewData {
        val allIds = museumRepository.fetchAllIds()
        val firstId = allIds.data?.objectIDs?.minOfOrNull { it }

        return when (val firstItem = museumRepository.fetchItemById(firstId.toString())) {
            is ResourceResponse.Success ->
                MuseumViewData.SuccessItem(firstItem.data!!)
            is ResourceResponse.Error ->
                MuseumViewData.Error(firstItem.message!!)
        }
    }
}