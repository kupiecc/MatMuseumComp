package net.jackapp.matmuseumcomp.data.resultdata

import net.jackapp.matmuseumcomp.data.json.MuseumSummary

sealed class MuseumSummaryResult {

    data class Summary(val summary: MuseumSummary): MuseumSummaryResult()
    data class Error(val message: String): MuseumSummaryResult()

}