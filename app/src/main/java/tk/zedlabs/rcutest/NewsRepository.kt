package tk.zedlabs.rcutest

import tk.zedlabs.rcutest.models.NewsResult
import tk.zedlabs.rcutest.network.JsonApi
import tk.zedlabs.rcutest.network.RetrofitService

class NewsRepository(){

    var client = RetrofitService().createService(JsonApi::class.java)
    val key = "d3fc865cd4ef4d878580d0e4b0d97ad4"
    suspend fun getNews() : NewsResult {
        return client.getNews("TechCrunch", key)
    }
}