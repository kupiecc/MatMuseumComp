package net.jackapp.matmuseumcomp.domain.repositories

import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.json.MuseumSummary
import net.jackapp.matmuseumcomp.data.response.ResourceResponse

interface MuseumRepository {

    suspend fun fetchItemById(id: String): ResourceResponse<MuseumItem>

    suspend fun fetchAllIds(): ResourceResponse<MuseumSummary>

}
