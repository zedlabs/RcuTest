package tk.zedlabs.rcutest.application

import android.app.Application
import tk.zedlabs.rcutest.dagger.AppComponent
import tk.zedlabs.rcutest.dagger.AppModule
import tk.zedlabs.rcutest.dagger.DaggerAppComponent

open class NewsApplication : Application() {


    companion object {
        lateinit var newsComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = initDagger(this)
    }

     private fun initDagger(app: NewsApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()

}