package net.jackapp.matmuseumcomp.domain.helper

import net.jackapp.matmuseumcomp.data.services.MuseumService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelperImpl: RetrofitHelper {

    override fun callMuseumApi(): MuseumService {
        return Retrofit.Builder().baseUrl("https://collectionapi.metmuseum.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MuseumService::class.java)
    }

}