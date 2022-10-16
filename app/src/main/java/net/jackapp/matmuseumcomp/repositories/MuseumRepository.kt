package net.jackapp.matmuseumcomp.repositories

import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.json.MuseumItemsSummary

interface MuseumRepository {

    suspend fun fetchItemById(id: String): MuseumItem?

    suspend fun fetchAllIds(): MuseumItemsSummary?

}
