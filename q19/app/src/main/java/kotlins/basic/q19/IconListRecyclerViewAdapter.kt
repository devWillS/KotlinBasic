package kotlins.basic.q19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class IconListRecyclerViewAdapter(private val itemsList: ArrayList<IconModel>?) :
    RecyclerView.Adapter<IconViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        val inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_item, parent, false)
        return IconViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return if (this.itemsList != null) this.itemsList.size else 0
    }

    override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
        val item = this.itemsList!![position]

        holder.imageView.tag = position
        holder.imageView.setImageDrawable(item.drawable)
        holder.text = item.text
    }
}