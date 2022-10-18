package net.jackapp.matmuseumcomp.domain.helper

import net.jackapp.matmuseumcomp.data.services.MuseumService

interface RetrofitHelper {
    fun callMuseumApi(): MuseumService
}