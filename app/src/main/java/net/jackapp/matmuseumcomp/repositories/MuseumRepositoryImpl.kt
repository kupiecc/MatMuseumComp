package net.jackapp.matmuseumcomp.repositories

import net.jackapp.matmuseumcomp.data.resultdata.MuseumItemResult
import net.jackapp.matmuseumcomp.data.resultdata.MuseumSummaryResult
import net.jackapp.matmuseumcomp.helper.RetrofitHelper
import retrofit2.HttpException
import java.io.IOException

class MuseumRepositoryImpl(
    private val retrofitHelper: RetrofitHelper
) : MuseumRepository {

    override suspend fun fetchItemById(id: String): MuseumItemResult {
        return try {
            val result = retrofitHelper.callMuseumApi().getObject(id).body()
            if (result != null) MuseumItemResult.Item(result)
            else MuseumItemResult.Error("Huston! We have a problem!")
        } catch (e: IOException) {
            return MuseumItemResult.Error(e.localizedMessage)
        } catch (e: HttpException) {
            return MuseumItemResult.Error(e.localizedMessage)
        }
    }

    override suspend fun fetchAllIds(): MuseumSummaryResult {
        return try {
            val result = retrofitHelper.callMuseumApi().getAllIds().body()
            if (result != null) MuseumSummaryResult.Summary(result)
            else MuseumSummaryResult.Error("Huston! We have a problem!")
        } catch (e: IOException) {
            return MuseumSummaryResult.Error(e.localizedMessage)
        } catch (e: HttpException) {
            return MuseumSummaryResult.Error(e.localizedMessage)
        }
    }

}