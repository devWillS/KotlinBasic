package kotlins.basic.q25.views.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlins.basic.q15.AlertDialogUtil
import kotlins.basic.q25.R
import kotlins.basic.q25.common.DividerItemDecoration
import kotlins.basic.q25.common.EditStatus
import kotlins.basic.q25.models.entity.Todo
import kotlins.basic.q25.utils.TodoUtil
import kotlins.basic.q25.views.register.TodoRegisterActivity
import kotlinx.android.synthetic.main.activity_todo_list.*

class TodoListActivity : AppCompatActivity(), TodoListAdapter.TodoAdapterListener, AlertDialogUtil.DialogUtilListener {

    private lateinit var adapter: TodoListAdapter
    private var todoList: ArrayList<Todo> = ArrayList()
    private var deleteId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)

        setupView()
    }

    override fun onResume() {
        super.onResume()
        reloadTodoList()
    }

    private fun setupView() {
        registerTodoButton.setOnClickListener {
            val intent = Intent(this, TodoRegisterActivity::class.java)
            intent.putExtra("editStatus", EditStatus.NEW)
            startActivity(intent)
        }



        adapter = TodoListAdapter(todoList, this)

        val llm = LinearLayoutManager(this)
        todoListRecyclerView.addItemDecoration(DividerItemDecoration(this))
        todoListRecyclerView.setHasFixedSize(true)
        todoListRecyclerView.layoutManager = llm
        todoListRecyclerView.adapter = adapter

        reloadTodoList()
    }

    private fun reloadTodoList() {
        todoList.clear()
        todoList.addAll(TodoUtil.getTodoList())
        adapter.notifyDataSetChanged()
    }

    override fun selectedTodo(todo: Todo) {
        val intent = Intent(application, TodoRegisterActivity::class.java)
        intent.putExtra("editStatus", EditStatus.EDIT)
        intent.putExtra("todo", todo.todoId)
        startActivity(intent)
    }

    override fun onLongClicked(position: Int) {
        deleteId = position
        AlertDialogUtil.createDialog(this,R.string.deleteTitle,R.string.deleteMessage, this)
    }

    override fun onPositive() {
        if (deleteId == -1) {
            return
        }

        TodoUtil.deleteTodo(deleteId)
        reloadTodoList()
        deleteId = -1
    }

    override fun onNegative() {
        deleteId = -1
    }
}
