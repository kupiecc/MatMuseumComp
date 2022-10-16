package net.jackapp.matmuseumcomp.repositories

import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.json.MuseumItemsSummary
import net.jackapp.matmuseumcomp.helper.RetrofitHelper
import retrofit2.HttpException
import java.io.IOException

class MuseumRepositoryImpl(
    private val retrofitHelper: RetrofitHelper
) : MuseumRepository {

    override suspend fun fetchItemById(id: String): MuseumItem? {
        return try {
            retrofitHelper.callMuseumApi().getObject(id).body()
        } catch (e: IOException) {
            return null
        } catch (e: HttpException) {
            return null
        }
    }

    override suspend fun fetchAllIds(): MuseumItemsSummary? {
        return try {
            retrofitHelper.callMuseumApi().getAllIds().body()
        } catch (e: IOException) {
            return null
        } catch (e: HttpException) {
            return null
        }

    }

}