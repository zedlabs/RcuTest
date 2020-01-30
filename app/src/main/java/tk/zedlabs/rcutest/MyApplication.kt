package tk.zedlabs.rcutest

import android.app.Application
import dagger.Component

@Component
interface ApplicationGraph {
    fun repository() : NewsRepository
}

class MyApplication : Application() {

    val appComponent: ApplicationGraph = DaggerApplicationComponent.create()

}