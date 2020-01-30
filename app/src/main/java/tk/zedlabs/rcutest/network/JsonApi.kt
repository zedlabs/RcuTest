package tk.zedlabs.rcutest.network

import retrofit2.http.GET
import retrofit2.http.Query
import tk.zedlabs.rcutest.models.NewsResult

interface JsonApi {
    @GET("/v2/top-headlines/")
    suspend fun getNews(@Query("sources") source : String,
                        @Query("apiKey") key : String) : NewsResult
}