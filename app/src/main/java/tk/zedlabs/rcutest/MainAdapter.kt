package tk.zedlabs.rcutest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.list_item.view.*
import tk.zedlabs.rcutest.models.Article

class MainAdapter(private val myDataset : List<Article>, onImageListener : OnImageListener) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {


    private var mOnImageListener: OnImageListener = onImageListener

    class MyViewHolder(view : View, var onImageListener: OnImageListener) : RecyclerView.ViewHolder(view), View.OnClickListener{
        init { view.setOnClickListener(this) }

        override fun onClick(v: View?) {
            onImageListener.onImageClick(adapterPosition)
        }
    }

    interface OnImageListener{ fun onImageClick(position: Int) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val newsCardView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(newsCardView, mOnImageListener)
    }

    override fun getItemCount(): Int {
       return myDataset.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.textTitle.text = myDataset[position].title
        holder.itemView.textTitle.setShadowLayer(30f, 0F, 0F, Color.BLACK)
        Glide.with(holder.itemView.context)
            .load(myDataset[position].urlToImage)
            .transform(CenterCrop())
            .into(holder.itemView.article_image)

    }
}