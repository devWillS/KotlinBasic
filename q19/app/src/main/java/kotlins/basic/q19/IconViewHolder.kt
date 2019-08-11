package kotlins.basic.q19

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.icon_item.view.*

class IconViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.imageView

    var text: String? = null

    init {

        itemView.setOnClickListener { v ->
            Toast.makeText(v.context, this@IconViewHolder.text, Toast.LENGTH_SHORT).show()
        }
    }
}