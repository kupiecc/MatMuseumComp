package net.jackapp.matmuseumcomp.data.viewdata

import net.jackapp.matmuseumcomp.data.json.MuseumItem

sealed class MuseumViewData {

    data class Success(
        val items: List<MuseumItem>
    ): MuseumViewData()

    data class Error(
        val message: String
    ): MuseumViewData()

    object Loading: MuseumViewData()

    object Empty: MuseumViewData()
}
