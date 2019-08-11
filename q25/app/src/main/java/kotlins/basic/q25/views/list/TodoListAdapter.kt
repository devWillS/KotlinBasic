package kotlins.basic.q25.views.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlins.basic.q25.R
import kotlins.basic.q25.models.entity.Todo
import kotlins.basic.q25.utils.DateUtil

class TodoListAdapter(
    var todoList: List<Todo>,
    var listener: TodoAdapterListener
) : RecyclerView.Adapter<TodoListViewHolder>() {
    interface TodoAdapterListener {
        fun onClicked(position: Int)
        fun onLongClicked(position: Int)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {

        holder.title.text = todoList[position].title
        holder.limit.text = DateUtil.toString(todoList[position].limitDate, DateUtil.DateFormat.HyphenYearToDay)

        holder.itemView.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            listener.onClicked(adapterPosition)
        }

        holder.itemView.setOnLongClickListener {
            val adapterPosition = holder.adapterPosition
            listener.onLongClicked(adapterPosition)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        return TodoListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_cell, parent, false))
    }
}
