package net.jackapp.matmuseumcomp.domain.repositories

import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.json.MuseumSummary
import net.jackapp.matmuseumcomp.data.response.ResourceResponse
import net.jackapp.matmuseumcomp.domain.helper.RetrofitHelper
import retrofit2.HttpException
import java.io.IOException

class MuseumRepositoryImpl(
    private val retrofitHelper: RetrofitHelper
) : MuseumRepository {

    override suspend fun fetchItemById(id: String): ResourceResponse<MuseumItem> {
        return try {
            val result = retrofitHelper.callMuseumApi().getObject(id).body()
            if (result != null)
                ResourceResponse.Success(result)
            else
                ResourceResponse.Error("Huston! We have a problem!")
        } catch (e: IOException) {
            return ResourceResponse.Error(e.localizedMessage)
        } catch (e: HttpException) {
            return ResourceResponse.Error(e.localizedMessage)
        }
    }

    override suspend fun fetchAllIds(): ResourceResponse<MuseumSummary> {
        return try {
            val result = retrofitHelper.callMuseumApi().getAllIds().body()
            if (result != null) ResourceResponse.Success(result)
            else ResourceResponse.Error("Huston! We have a problem!")
        } catch (e: IOException) {
            return ResourceResponse.Error(e.localizedMessage)
        } catch (e: HttpException) {
            return ResourceResponse.Error(e.localizedMessage)
        }
    }

}