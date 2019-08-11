package kotlins.basic.q18

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TestRecycleViewAdapter(private val list: List<RowData>) : RecyclerView.Adapter<TestViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return TestViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.imageView.setImageDrawable(list[position].image)
        holder.detailView.text = list[position].detail
    }
}