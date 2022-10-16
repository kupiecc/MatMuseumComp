package net.jackapp.matmuseumcomp.data.resultdata

import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.json.MuseumSummary

sealed class MuseumItemResult {

    data class Item(val item: MuseumItem): MuseumItemResult()
    data class Error(val message: String): MuseumItemResult()

}