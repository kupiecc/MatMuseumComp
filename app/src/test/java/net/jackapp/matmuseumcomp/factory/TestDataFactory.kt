package net.jackapp.matmuseumcomp.factory

import net.jackapp.matmuseumcomp.data.json.*

object TestDataFactory {

    fun createMuseumSummary() : MuseumSummary {
        return MuseumSummary(
            objectIDs = listOf(1, 2, 3),
            total = 3
        )
    }

    fun createMuseumItem(): MuseumItem {
        return MuseumItem(
            accessionNumber = "accessionNumber",
            accessionYear = "accessionYear",
            additionalImages = listOf("additionalImages"),
            artistAlphaSort = "artistAlphaSort",
            artistBeginDate = "artistBeginDate",
            artistDisplayBio = "artistDisplayBio",
            artistDisplayName = "artistDisplayName",
            artistEndDate = "artistEndDate",
            artistGender = "artistGender",
            artistNationality = "artistNationality",
            artistPrefix = "artistPrefix",
            artistRole = "artistRole",
            artistSuffix = "artistSuffix",
            artistULANURL = "artistULANURL",
            artistWikidataURL = "artistWikidataURL",
            city = "city",
            classification = "classification",
            constituents = listOf(Constituent(0, "", "", "", "", "")),
            country = "country",
            county = "county",
            creditLine = "creditLine",
            culture = "culture",
            department = "department",
            dimensions = "dimensions",
            dynasty = "dynasty",
            excavation = "excavation",
            galleryNumber = "galleryNumber",
            geographyType = "geographyType",
            isHighlight = true,
            isPublicDomain = true,
            isTimelineWork = true,
            linkResource = "linkResource",
            locale = "locale",
            locus = "locus",
            measurements = listOf(Measurement("", ElementMeasurements(0.0, 0.0, 0.0), "")),
            medium = "medium",
            metadataDate = "metadataDate",
            objectBeginDate = 0,
            objectDate = "objectDate",
            objectEndDate = 0,
            objectID = 1,
            objectName = "objectName",
            objectURL = "objectURL",
            objectWikidataURL = "objectWikidataURL",
            period = "period",
            portfolio = "portfolio",
            primaryImage = "primaryImage",
            primaryImageSmall = "primaryImageSmall",
            region = "region",
            reign = "reign",
            repository = "repository",
            rightsAndReproduction = "rightsAndReproduction",
            river = "river",
            state = "state",
            subregion = "subregion",
            tags = listOf(Tag("", "", "")),
            title = "title"
        )
    }
}