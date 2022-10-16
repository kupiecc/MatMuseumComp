package net.jackapp.matmuseumcomp.helper

import net.jackapp.matmuseumcomp.services.MuseumService

interface RetrofitHelper {
    fun callMuseumApi(): MuseumService
}