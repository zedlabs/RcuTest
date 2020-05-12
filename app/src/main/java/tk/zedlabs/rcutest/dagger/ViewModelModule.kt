package tk.zedlabs.rcutest.dagger

import dagger.Module
import dagger.Provides
import tk.zedlabs.rcutest.MainViewModel
import tk.zedlabs.rcutest.MainViewModelFactory
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun providedViewModel() : MainViewModelFactory = MainViewModelFactory()

}