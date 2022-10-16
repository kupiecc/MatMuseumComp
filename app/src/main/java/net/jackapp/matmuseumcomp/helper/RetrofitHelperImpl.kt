package net.jackapp.matmuseumcomp.helper

import net.jackapp.matmuseumcomp.services.MuseumService
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