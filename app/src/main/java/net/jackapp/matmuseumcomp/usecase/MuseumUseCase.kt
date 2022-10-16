package net.jackapp.matmuseumcomp.usecase

import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.repositories.MuseumRepository

class MuseumUseCase(
    private val museumRepository: MuseumRepository
) {

    suspend fun getFirstAvailableItem(): MuseumItem? {
        val allIds = museumRepository.fetchAllIds()
        val firstItem = if (allIds != null) {
            val firstId = allIds.objectIDs.minOf { it }
            museumRepository.fetchItemById(firstId.toString())
        } else {
            null
        }
        return firstItem
    }

}