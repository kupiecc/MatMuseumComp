package net.jackapp.matmuseumcomp.data.json


import com.google.gson.annotations.SerializedName

data class Constituent(
    @SerializedName("constituentID")
    val constituentID: Int,
    @SerializedName("constituentULAN_URL")
    val constituentULANURL: String,
    @SerializedName("constituentWikidata_URL")
    val constituentWikidataURL: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("role")
    val role: String
)