package net.jackapp.matmuseumcomp.services

import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.json.MuseumItemsSummary
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MuseumService {

    @GET("/public/collection/v1/objects/{id}")
    suspend fun getObject(@Path("id") key: String): Response<MuseumItem>

    @GET("https://collectionapi.metmuseum.org/public/collection/v1/objects")
    suspend fun getAllIds(): Response<MuseumItemsSummary>

 }