package kotlins.basic.q25.views.list


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlins.basic.q15.AlertDialogUtil

import kotlins.basic.q25.R
import kotlins.basic.q25.common.DividerItemDecoration
import kotlins.basic.q25.common.EditStatus
import kotlins.basic.q25.models.entity.Todo
import kotlins.basic.q25.utils.TodoUtil
import kotlins.basic.q25.views.register.TodoRegisterActivity
import kotlinx.android.synthetic.main.fragment_todo_list.*

/**
 * A simple [Fragment] subclass.
 *
 */
class TodoListFragment :
    Fragment(),
    TodoListContracts.View,
    TodoListAdapter.TodoAdapterListener,
    AlertDialogUtil.DialogUtilListener {

    private lateinit var presenter: TodoListContracts.Presenter
    private lateinit var adapter: TodoListAdapter
    private var deletePosition = -1

    override fun setPresenter(presenter: TodoListContracts.Presenter) {
        this.presenter = presenter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun setupView(todoList: List<Todo>) {
        registerTodoButton.setOnClickListener {
            presenter.registerTodoButtonClicked()
        }

        adapter = TodoListAdapter(todoList, this)

        val llm = LinearLayoutManager(context)
        todoListRecyclerView.addItemDecoration(DividerItemDecoration(context!!))
        todoListRecyclerView.setHasFixedSize(true)
        todoListRecyclerView.layoutManager = llm
        todoListRecyclerView.adapter = adapter
    }

    override fun onClicked(position: Int) {
        presenter.todoSelected(position)
    }

    override fun onLongClicked(position: Int) {
        this.deletePosition = position
        AlertDialogUtil.createDialog(context!!, fragmentManager!!, R.string.deleteTitle, R.string.deleteMessage, this)
    }

    override fun onPositive() {
        if (deletePosition == -1) {
            return
        }

        presenter.deletePosition(deletePosition)

        deletePosition = -1
    }

    override fun onNegative() {
        deletePosition = -1
    }

    override fun notifyDataSetChanged() {
        adapter.notifyDataSetChanged()
    }
}
