package net.jackapp.matmuseumcomp.data.json


import com.google.gson.annotations.SerializedName
import net.jackapp.matmuseumcomp.data.json.Constituent
import net.jackapp.matmuseumcomp.data.json.Measurement
import net.jackapp.matmuseumcomp.data.json.Tag

data class MuseumItem(
    @SerializedName("accessionNumber")
    val accessionNumber: String,
    @SerializedName("accessionYear")
    val accessionYear: String,
    @SerializedName("additionalImages")
    val additionalImages: List<Any>,
    @SerializedName("artistAlphaSort")
    val artistAlphaSort: String,
    @SerializedName("artistBeginDate")
    val artistBeginDate: String,
    @SerializedName("artistDisplayBio")
    val artistDisplayBio: String,
    @SerializedName("artistDisplayName")
    val artistDisplayName: String,
    @SerializedName("artistEndDate")
    val artistEndDate: String,
    @SerializedName("artistGender")
    val artistGender: String,
    @SerializedName("artistNationality")
    val artistNationality: String,
    @SerializedName("artistPrefix")
    val artistPrefix: String,
    @SerializedName("artistRole")
    val artistRole: String,
    @SerializedName("artistSuffix")
    val artistSuffix: String,
    @SerializedName("artistULAN_URL")
    val artistULANURL: String,
    @SerializedName("artistWikidata_URL")
    val artistWikidataURL: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("classification")
    val classification: String,
    @SerializedName("constituents")
    val constituents: List<Constituent>,
    @SerializedName("country")
    val country: String,
    @SerializedName("county")
    val county: String,
    @SerializedName("creditLine")
    val creditLine: String,
    @SerializedName("culture")
    val culture: String,
    @SerializedName("department")
    val department: String,
    @SerializedName("dimensions")
    val dimensions: String,
    @SerializedName("dynasty")
    val dynasty: String,
    @SerializedName("excavation")
    val excavation: String,
    @SerializedName("GalleryNumber")
    val galleryNumber: String,
    @SerializedName("geographyType")
    val geographyType: String,
    @SerializedName("isHighlight")
    val isHighlight: Boolean,
    @SerializedName("isPublicDomain")
    val isPublicDomain: Boolean,
    @SerializedName("isTimelineWork")
    val isTimelineWork: Boolean,
    @SerializedName("linkResource")
    val linkResource: String,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("locus")
    val locus: String,
    @SerializedName("measurements")
    val measurements: List<Measurement>,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("metadataDate")
    val metadataDate: String,
    @SerializedName("objectBeginDate")
    val objectBeginDate: Int,
    @SerializedName("objectDate")
    val objectDate: String,
    @SerializedName("objectEndDate")
    val objectEndDate: Int,
    @SerializedName("objectID")
    val objectID: Int,
    @SerializedName("objectName")
    val objectName: String,
    @SerializedName("objectURL")
    val objectURL: String,
    @SerializedName("objectWikidata_URL")
    val objectWikidataURL: String,
    @SerializedName("period")
    val period: String,
    @SerializedName("portfolio")
    val portfolio: String,
    @SerializedName("primaryImage")
    val primaryImage: String,
    @SerializedName("primaryImageSmall")
    val primaryImageSmall: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("reign")
    val reign: String,
    @SerializedName("repository")
    val repository: String,
    @SerializedName("rightsAndReproduction")
    val rightsAndReproduction: String,
    @SerializedName("river")
    val river: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("subregion")
    val subregion: String,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("title")
    val title: String
)