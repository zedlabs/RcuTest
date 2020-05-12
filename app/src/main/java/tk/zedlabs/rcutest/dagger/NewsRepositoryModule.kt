package tk.zedlabs.rcutest.dagger

import dagger.Module
import dagger.Provides
import tk.zedlabs.rcutest.NewsRepository
import javax.inject.Singleton

@Module
class NewsRepositoryModule {

    @Provides
    @Singleton
    fun providedNewsRepository() : NewsRepository = NewsRepository()
}