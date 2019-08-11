package kotlins.basic.q25.views.list

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_cell.view.*

class TodoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.titleTextView
    val limit: TextView = itemView.limitTextView
    val linear: LinearLayout = itemView.linear

}