package net.jackapp.matmuseumcomp.repositories

import net.jackapp.matmuseumcomp.data.resultdata.MuseumItemResult
import net.jackapp.matmuseumcomp.data.resultdata.MuseumSummaryResult

interface MuseumRepository {

    suspend fun fetchItemById(id: String): MuseumItemResult

    suspend fun fetchAllIds(): MuseumSummaryResult

}
