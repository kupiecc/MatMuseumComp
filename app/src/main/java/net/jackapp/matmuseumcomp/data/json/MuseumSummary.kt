package net.jackapp.matmuseumcomp.data.json


import com.google.gson.annotations.SerializedName

data class MuseumSummary(
    @SerializedName("objectIDs")
    val objectIDs: List<Int>,
    @SerializedName("total")
    val total: Int
)