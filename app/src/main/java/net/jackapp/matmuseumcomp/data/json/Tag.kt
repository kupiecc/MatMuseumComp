package net.jackapp.matmuseumcomp.data.json


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("AAT_URL")
    val aATURL: String,
    @SerializedName("term")
    val term: String,
    @SerializedName("Wikidata_URL")
    val wikidataURL: String
)