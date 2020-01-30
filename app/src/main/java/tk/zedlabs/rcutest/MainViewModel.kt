package tk.zedlabs.rcutest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import tk.zedlabs.rcutest.models.NewsResult

class MainViewModel : ViewModel() {
    val applicationGraph: ApplicationGraph = DaggerApplicationGraph.create()
    val newsRepository : NewsRepository = applicationGraph.repository()

    val data : LiveData<NewsResult> = liveData(Dispatchers.IO) {
        val retrievedData = newsRepository.getNews()
        emit(retrievedData)
    }
}