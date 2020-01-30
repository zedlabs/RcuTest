package tk.zedlabs.rcutest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tk.zedlabs.rcutest.MainAdapter
import tk.zedlabs.rcutest.MainViewModel
import tk.zedlabs.rcutest.R

class MainActivity : AppCompatActivity(), MainAdapter.OnImageListener {

    private lateinit var mainViewModel : MainViewModel

    override fun onImageClick(position: Int) {
        val i = Intent(this, DetailsActivity::class.java)
        i.putExtra("position", position)
        Log.e("MainActivity", "position: $position")
        startActivity(i)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "News App"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel()
        val viewManager = LinearLayoutManager(this)
        mainViewModel.data.observe(this, Observer {
            val myDataset = it.articles!!
            val viewAdapter = MainAdapter(myDataset, this)
            recyclerView.apply {
                layoutManager = viewManager
                adapter =viewAdapter
            }
        })

    }
}
