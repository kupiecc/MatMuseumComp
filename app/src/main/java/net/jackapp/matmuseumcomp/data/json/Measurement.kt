package net.jackapp.matmuseumcomp.data.json

import com.google.gson.annotations.SerializedName

data class Measurement(
    @SerializedName("elementDescription")
    val elementDescription: Any,
    @SerializedName("elementMeasurements")
    val elementMeasurements: ElementMeasurements,
    @SerializedName("elementName")
    val elementName: String
)