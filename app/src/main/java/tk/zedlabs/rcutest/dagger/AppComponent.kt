package tk.zedlabs.rcutest.dagger

import dagger.Component
import tk.zedlabs.rcutest.MainViewModelFactory
import tk.zedlabs.rcutest.ui.DetailsActivity
import tk.zedlabs.rcutest.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, NewsRepositoryModule::class])
interface AppComponent {

    fun inject(target: MainActivity)
    fun inject(target : MainViewModelFactory)
    fun inject(target : DetailsActivity)

}