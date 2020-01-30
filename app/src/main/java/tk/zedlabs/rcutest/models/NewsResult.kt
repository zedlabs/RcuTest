package tk.zedlabs.rcutest.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import tk.zedlabs.rcutest.models.Article


class NewsResult {
    @SerializedName("status")
    @Expose
    val status: String? = null
    @SerializedName("totalResults")
    @Expose
    val totalResults: Int? = null
    @SerializedName("articles")
    @Expose
    val articles: List<Article>? = null
}