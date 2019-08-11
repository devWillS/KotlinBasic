package kotlins.basic.q25.views.list

import kotlins.basic.q25.models.entity.Todo
import kotlins.basic.q25.utils.TodoUtil


class TodoListModel:TodoListContracts.Model {

    private lateinit var presenter: TodoListContracts.Presenter

    override fun setPresenter(presenter: TodoListContracts.Presenter) {
        this.presenter = presenter
    }

    override fun getAllTodo(): List<Todo> {
        return TodoUtil.getTodoList()
    }

    override fun deleteTodo(todoId: Int) {
        TodoUtil.deleteTodo(todoId)
    }
}