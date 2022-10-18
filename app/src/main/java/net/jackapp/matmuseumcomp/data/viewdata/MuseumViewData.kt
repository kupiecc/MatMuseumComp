package net.jackapp.matmuseumcomp.data.viewdata

import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.json.MuseumSummary

sealed class MuseumViewData {
    class SuccessItem(
        val item: MuseumItem
    ) : MuseumViewData()

    class SuccessSummary(
        val summary: MuseumSummary
    ) : MuseumViewData()

    class Error(
        val message: String
    ) : MuseumViewData()

    object Loading : MuseumViewData()
}