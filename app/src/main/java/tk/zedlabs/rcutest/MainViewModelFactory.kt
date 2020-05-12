package tk.zedlabs.rcutest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tk.zedlabs.rcutest.application.NewsApplication
import javax.inject.Inject

class MainViewModelFactory : ViewModelProvider.Factory {

    @Inject lateinit var newsRepository :NewsRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        NewsApplication.newsComponent.inject(this)  //injects repository
        return MainViewModel(newsRepository) as T
    }


}