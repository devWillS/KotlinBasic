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

class TodoListActivity : AppCompatActivity(), TodoListContracts.Presenter {

    private val model: TodoListContracts.Model = TodoListModel()
    private lateinit var view: TodoListContracts.View

    private var todoList: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)

    }

    override fun onStart() {
        super.onStart()
        model.setPresenter(this)
        view = todoListFragment as TodoListFragment
        view.setPresenter(this)
        setupView()
    }

    override fun onResume() {
        super.onResume()
        reloadTodoList()
    }

    private fun setupView() {
        view.setupView(todoList)
        reloadTodoList()
    }

    private fun reloadTodoList() {
        todoList.clear()
        todoList.addAll(model.getAllTodo())
        view.notifyDataSetChanged()
    }

    override fun registerTodoButtonClicked() {
        val intent = Intent(this, TodoRegisterActivity::class.java)
        intent.putExtra("editStatus", EditStatus.NEW)
        startActivity(intent)
    }

    override fun todoSelected(position: Int) {
        val todo = todoList.get(position)
        val intent = Intent(application, TodoRegisterActivity::class.java)
        intent.putExtra("editStatus", EditStatus.EDIT)
        intent.putExtra("todo", todo.todoId)
        startActivity(intent)
    }

    override fun deletePosition(position: Int) {
        val todoId = todoList.get(position).todoId
        model.deleteTodo(todoId)
        reloadTodoList()
    }
}
