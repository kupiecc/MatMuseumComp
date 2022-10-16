package net.jackapp.matmuseumcomp.data.json


import com.google.gson.annotations.SerializedName

data class ElementMeasurements(
    @SerializedName("Depth")
    val depth: Double,
    @SerializedName("Height")
    val height: Double,
    @SerializedName("Width")
    val width: Double
)