package tk.zedlabs.rcutest.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.activity_details.*
import tk.zedlabs.rcutest.MainViewModel
import tk.zedlabs.rcutest.R


class DetailsActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        val i = intent
        val position = i.getIntExtra("position", 0)

        Log.e("DetailsActivity", "position: $position")
        mainViewModel = MainViewModel()
        mainViewModel.data.observe(this, Observer {
            val currentArticle = it.articles!![position]
            Glide.with(this)
                .asDrawable()
                .load(currentArticle.urlToImage)
                .into(object : CustomTarget<Drawable>() {
                    override fun onLoadCleared(placeholder: Drawable?) { }
                    override fun onResourceReady(resource: Drawable,transition: Transition<in Drawable>?) {
                        titleTextView.background = resource
                    }
                })
            title = currentArticle.author
            titleTextView.text = currentArticle.title
            articleBody.text = currentArticle.content
            Author.text = currentArticle.author
            titleTextView.setShadowLayer(30f, 2F, 0F, Color.WHITE)
            readMore.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(currentArticle.url)))
            }
        })
    }
}
